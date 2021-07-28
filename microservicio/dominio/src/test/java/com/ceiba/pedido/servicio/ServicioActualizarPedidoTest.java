package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarPedidoTest {
    @Test
    public void validarActualizacionPedidoTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conId(1L).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioActualizarPedido servicioActualizarPedido = new ServicioActualizarPedido(repositorioPedido);
        servicioActualizarPedido.ejecutar(pedido);
        String ciudad = "medellin";
        // act - assert
        Assert.assertEquals(pedido.getCiudad(), ciudad);


    }
}
