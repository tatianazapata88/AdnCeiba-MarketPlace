package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class ServicioCrearPedidoTest {

    private static final LocalDate FECHA = LocalDate.of(2021,8,2);
    private static final Long BICI =1L;
    private static final Long COMPRADOR = 2L;
    private static final String CIUDAD = "Medellin";
    private static final String DESTINO = "Cartagena";
    private static final Integer PRECIO = 1000000;

    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
    private static final String CAMPO_BICI_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_DESTINO_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";
    private static final String NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA = "No se puede registrar el pedido, la scotter ya se encuentra reservada";



    @Mock
    private RepositorioPedido repositorioPedido;

    @InjectMocks
    private ServicioCrearPedido servicioCrearPedido;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarCampoFechaVacioTest(){
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(null,BICI,COMPRADOR,CIUDAD,DESTINO,PRECIO);
        // act - assert
        BasePrueba.assertThrows(() -> pedidoTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_FECHA_ES_OBLIGATORIO);
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
    public void validarCampoCiudadBlancoTest() {
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,COMPRADOR," ",DESTINO,PRECIO);
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
    public void validarCampoDestinoBlancTest() {
        // arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(FECHA,BICI,COMPRADOR,CIUDAD," ",PRECIO);
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
    public void validarCalcularValorFleteCiudadIgualTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conCiudadYDestino("medellin","medellin").build();
        int flete = 0;
        //assert
        Assert.assertEquals(pedido.getFlete(),flete);
    }

    @Test
    public void validarCalcularValorFleteCiudadDiferenteTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conCiudadYDestino("cali","medellin").build();
        int flete = 30000;
        //assert
        Assert.assertEquals(pedido.getFlete(),flete);
    }

    @Test
    public void validarCalcularValorTotalTest() {
        // arrange
       Pedido pedido = new PedidoTestDataBuilder().build();
        int total = 3830000;
        //assert
        Assert.assertEquals(pedido.getTotal(),total);
    }

    @Test
    public void validarDescuentoPagoTestMismaFecha() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFecha(LocalDate.of(2021,8,2)).build();
        int descuento = 200000;
        //assert
        Assert.assertEquals(pedido.getDescuento(),descuento);
    }

    @Test
    public void validarDescuentoPagoTestDiferenteFecha() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFecha(LocalDate.of(2021,8,3)).build();
        int descuento = 0;
        //assert
        Assert.assertEquals(pedido.getDescuento(),descuento);
    }

    @Test
    public void validarScotterReservadaPreviaTest() {
        // arrange
        Long bici = 1L;
        Pedido pedido = new PedidoTestDataBuilder().conBici(bici).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        Mockito.when(repositorioPedido.existe(Mockito.any())).thenReturn(true);
        ServicioCrearPedido servicioCrearPedido = new ServicioCrearPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPedido.ejecutar(pedido), ExcepcionDuplicidad.class, NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA);
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
