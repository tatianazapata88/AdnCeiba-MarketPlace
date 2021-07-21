package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioPedido {

    Long crear(Pedido pedido);


    void actualizar(Pedido pedido);


    void eliminar(Long id);


}
