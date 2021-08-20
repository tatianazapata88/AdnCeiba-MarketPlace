package com.ceiba.scotter.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;

import java.util.List;

public interface RepositorioScotter {

    Long crear(Scotter scotter);

    void actualizar(Scotter scotter);

    void eliminar(Long id);

    boolean existePorPedido(Long id);

    Scotter obtenerScotterPorId(Long id);
   }
