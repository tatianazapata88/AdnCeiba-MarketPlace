package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class ServicioCrearPedidoTest {

    private static final LocalDate FECHA =LocalDate.now();
    private static final Long BICI =1L;
    private static final Long COMPRADOR = 2L;
    private static final String CIUDAD = "Medellin";
    private static final String DESTINO = "Cartagena";
    private static final Integer PRECIO = 1000000;

    private static final String CAMPO_BICI_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_DESTINO_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";


    @Mock
    private RepositorioPedido repositorioPedido;

    @InjectMocks
    private ServicioCrearPedido servicioCrearPedido;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarCampoBiciVacioTest(){
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,null,COMPRADOR,CIUDAD,DESTINO,PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_BICI_ES_OBLIGATORIO);
    }

     @Test
    public void validarCampoCompradorVacioTest() {
        // arrange
         PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,null,CIUDAD,DESTINO,PRECIO);
         // act - assert
         BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_COMPRADOR_ES_OBLIGATORIO);
     }

    @Test
    public void validarCampoCiudadVacioTest() {
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,COMPRADOR,null,DESTINO,PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_ES_OBLIGATORIO);
    }


    @Test
    public void validarCampoDestinoVacioTest() {
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,COMPRADOR,CIUDAD,null,PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_DESTINO_ES_OBLIGATORIO);
    }

       @Test
    public void validarCampoPrecioVacioTest() {
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,COMPRADOR,CIUDAD,DESTINO,0);
        // act - assert
        BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_PRECIO_ES_OBLIGATORIO);
    }

      @Test
    public void agregarPedidoTest() {
        //arrange

        Pedido pedido = new PedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioCrearPedido servicioCrearPedido = new ServicioCrearPedido(repositorioPedido);
        servicioCrearPedido.ejecutar(pedido);
        String ciudad = "medellin";
        // act - assert
        Assert.assertEquals(pedido.getCiudad(),ciudad);
        ;
    }

}
