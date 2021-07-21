package com.ceiba.pedido.servicio;


import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

import com.ceiba.scotter.puerto.dao.DaoScotter;


public class ServicioCrearPedido {

    private final RepositorioPedido repositorioPedido;

    private  DaoScotter daoScotter;



    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
        this.daoScotter = daoScotter;
    }

    public Long ejecutar(Pedido pedido) {

       return this.repositorioPedido.crear(pedido);
    }


}
