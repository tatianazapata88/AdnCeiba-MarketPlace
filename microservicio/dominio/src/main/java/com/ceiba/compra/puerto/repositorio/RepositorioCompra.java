package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;

public interface RepositorioCompra {

    Long crear(Compra compra);

    void eliminar(Long id);

    boolean existe(Long id);


    Persona obtenerId(Long id);

    Scotter obtenerIdScotter(Long id);

}
