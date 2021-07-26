package com.ceiba.scotter.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRelacionado;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;

public class ServicioCrearScotter {
    private final RepositorioScotter repositorioScotter;

    public ServicioCrearScotter (RepositorioScotter repositorioScotter){
        this.repositorioScotter = repositorioScotter;
    }

    public Long ejecutar(Scotter scotter){

        return this.repositorioScotter.crear(scotter);
    }


}
