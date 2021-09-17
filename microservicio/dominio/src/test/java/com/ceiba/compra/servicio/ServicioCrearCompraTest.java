package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class ServicioCrearCompraTest {

    private static final LocalDate FECHA = LocalDate.now();
    private static final Scotter SCOTTER = new Scotter(1L, "honda", "2021", 1000000, "medellin", new Persona(1l, "taty", "Luz Tatiana", "3135151617", "taty@gmail.com"), "esta");
    private static final Persona COMPRADOR = new Persona(2l, "salo", "salome agudelo", "3003680128", "salo@gmail.com");
    private static final String CIUDAD_DESTINO_ENVIO = "Medellin";
    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;
    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
    private static final String CAMPO_SCOTTER_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_FECHA_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL = "La fecha no puede ser inferior a la fecha actual";
    private static final String CAMPO_FECHA_NO_PUEDE_SER_MAYOR_A_5_DIAS_DE_LA_FECHA_ACTUAL = "La fecha no puede ser mayor a 5 dias despues a la fecha actual";

    @Mock
    private RepositorioCompra repositorioCompra;

    @InjectMocks
    private ServicioCrearCompra servicioCrearCompra;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarCampoFechaNullTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(null, SCOTTER, COMPRADOR, CIUDAD_DESTINO_ENVIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_FECHA_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoScotterNullTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, null, COMPRADOR, CIUDAD_DESTINO_ENVIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCompradorNullTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER, null, CIUDAD_DESTINO_ENVIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_COMPRADOR_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadDestinoNullTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER, COMPRADOR, null);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCalcularValorFleteCiudadoOrigenIgualCiudadDestinoTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conCiudadDestino("medellin").build();
        //assert
        Assert.assertEquals(VALOR_FLETE_MISMA_CIUDAD, compra.getFlete(), 1);
    }

    @Test
    public void validarCalcularValorFleteCiudadOrigenDiferenteCiudadDestinoTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conCiudadDestino("cali").build();
        //assert
        Assert.assertEquals(VALOR_FLETE_DIFERENTE_CIUDAD, compra.getFlete(), 0);
    }

    @Test
    public void validarCalcularValorTotalTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        double total = 980000.0;
        //assert
        Assert.assertEquals(total, compra.getTotal(), 0);
    }

    @Test
    public void validarDescuentoPagoTestMismaFecha() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conFecha(LocalDate.now()).build();
        double descuento = 50000.0;
        //assert
        Assert.assertEquals(descuento, compra.getDescuento(), 0);
    }

    @Test
    public void validarDescuentoPagoTestDiferenteFecha() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conFecha(LocalDate.of(2021, 9, 20)).build();
        //assert
        Assert.assertEquals(SIN_DESCUENTO, compra.getDescuento(), 0);
    }

    @Test
    public void validarTestFechaInferior() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(LocalDate.of(2021,9,01), SCOTTER, COMPRADOR, CIUDAD_DESTINO_ENVIO);
        //assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorInvalido.class, CAMPO_FECHA_NO_PUEDE_SER_MENOR_A_LA_FECHA_ACTUAL);

    }

    @Test
    public void crearCompraTest() {
        //arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        servicioCrearCompra.ejecutar(compra);
        String ciudadDestino = "bogota";
        // act - assert
        Assert.assertEquals(compra.getCiudadDestinoEnvioScotter(), ciudadDestino);
    }
}
