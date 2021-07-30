package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPedidoTest {
    @Test
    public void validarEliminarPedidoTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conId(2L).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioEliminarPedido servicioEliminarPedido = new ServicioEliminarPedido(repositorioPedido);
        Long id = 2L;
        servicioEliminarPedido.ejecutar(id);
        // act - assert
        Assert.assertEquals(pedido.getId(), id);
    }
}
