package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;


public interface RepositorioPedido {

    Long crear(Pedido pedido);


    void actualizar(Pedido pedido);


    void eliminar(Long id);

    boolean existe(Long bici);

    void cambiarEstado(Long bici);


}
