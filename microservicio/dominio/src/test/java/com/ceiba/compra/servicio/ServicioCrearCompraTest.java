package com.ceiba.compra.servicio;

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

    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;

    @Mock
    private RepositorioCompra repositorioCompra;

    @InjectMocks
    private ServicioCrearCompra servicioCrearCompra;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
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
        Compra compra = new CompraTestDataBuilder().conFecha(LocalDate.of(2021, 8, 2)).build();
        //assert
        Assert.assertEquals(SIN_DESCUENTO, compra.getDescuento(), 0);
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
