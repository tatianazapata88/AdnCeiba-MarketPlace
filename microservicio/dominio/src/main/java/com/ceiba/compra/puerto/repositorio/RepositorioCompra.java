package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

public interface RepositorioCompra {

    Long crear(Compra compra);

    void actualizar(Compra compra);

    void eliminar(Long id);

    boolean existe(Long scotter_id);

    //  void cambiarEstado(Long bici);
}
