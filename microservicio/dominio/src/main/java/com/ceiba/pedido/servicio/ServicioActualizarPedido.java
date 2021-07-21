package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarPedido {

   private final RepositorioPedido repositorioPedido;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido) {
        this.repositorioPedido.actualizar(pedido);
    }



}
