package com.ceiba.pedido.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;


public class ServicioCrearPedido {

    private final RepositorioPedido repositorioPedido;

    private static final String NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA = "No se puede registrar el pedido, la scotter ya se encuentra reservada";

    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido) {
        validarExistenciaPedido(pedido);
       //this.repositorioPedido.cambiarEstado(pedido.getBici());
       return this.repositorioPedido.crear(pedido);
    }

    private void validarExistenciaPedido(Pedido pedido) {
        boolean existePedido = this.repositorioPedido.existe(pedido.getBici());
        if (existePedido) {
            throw new ExcepcionDuplicidad(NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA);
        }
    }


}
