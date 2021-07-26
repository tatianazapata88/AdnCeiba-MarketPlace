package com.ceiba.scotter.puerto.repositorio;

import com.ceiba.scotter.modelo.entidad.Scotter;

public interface RepositorioScotter {

    Long crear(Scotter scotter);

   void actualizar(Scotter scotter);

    void eliminar(Long id);

    boolean existePorPedido(Long id);
}
