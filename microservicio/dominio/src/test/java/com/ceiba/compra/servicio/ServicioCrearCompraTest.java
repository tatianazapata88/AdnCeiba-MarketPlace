package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class ServicioCrearCompraTest {

    private static final LocalDate FECHA = LocalDate.of(2021, 8, 2);
    private static final Long SCOTTER_ID = 1L;
    private static final Long COMPRADOR = 2L;
    private static final String CIUDAD_ORIGEN_SCOTTER = "Medellin";
    private static final String CIUDAD_DESTINO_SCOTTER = "Cartagena";
    private static final Integer PRECIO = 1000000;
    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;

    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
    private static final String CAMPO_SCOTTER_ID_ES_OBLIGATORIO = "El campo scotter ID obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ORIGEN_SCOTTER_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";
    private static final String NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA = "No se puede registrar el pedido, la scotter ya se encuentra reservada";

    @Mock
    private RepositorioCompra repositorioCompra;

    @InjectMocks
    private ServicioCrearCompra servicioCrearCompra;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

 /*   @Test
    public void validarCampoFechaVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(null, SCOTTER_ID, COMPRADOR, CIUDAD_ORIGEN_SCOTTER, CIUDAD_DESTINO_SCOTTER, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_FECHA_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoScotterIdVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, null, COMPRADOR, CIUDAD_ORIGEN_SCOTTER, CIUDAD_DESTINO_SCOTTER, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_SCOTTER_ID_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCompradorVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, null, CIUDAD_ORIGEN_SCOTTER, CIUDAD_DESTINO_SCOTTER, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_COMPRADOR_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadOrigenVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, COMPRADOR, null, CIUDAD_DESTINO_SCOTTER, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_ORIGEN_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadOrigenBlancoTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, COMPRADOR, " ", CIUDAD_DESTINO_SCOTTER, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_ORIGEN_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadDestinoVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, COMPRADOR, CIUDAD_ORIGEN_SCOTTER, null, PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadDestinoBlancTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, COMPRADOR, CIUDAD_ORIGEN_SCOTTER, " ", PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoPrecioVacioTest() {
        // arrange
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder(FECHA, SCOTTER_ID, COMPRADOR, CIUDAD_ORIGEN_SCOTTER, CIUDAD_DESTINO_SCOTTER, 0);
        // act - assert
        BasePrueba.assertThrows(() -> compraTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_PRECIO_ES_OBLIGATORIO);
    }*/

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
        Compra compra = new CompraTestDataBuilder().conFecha(LocalDate.of(2021, 8, 2)).build();
        //assert
        Assert.assertEquals(SIN_DESCUENTO, compra.getDescuento(), 0);
    }

   /* @Test
    public void validarScotterReservadaPreviaTest() {
        // arrange
        Long scotterId = 1L;
        Compra compra = new CompraTestDataBuilder().conScotterId(scotterId).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(Mockito.any())).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class, NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA);
    }*/

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
        ;
    }


}
