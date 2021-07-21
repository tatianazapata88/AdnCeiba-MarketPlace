package com.ceiba.pedido.servicio;

import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarPedido {


        private final RepositorioPedido repositorioPedido;

    public ServicioEliminarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

        public void ejecutar(Long id) {
        this.repositorioPedido.eliminar(id);
    }
}

