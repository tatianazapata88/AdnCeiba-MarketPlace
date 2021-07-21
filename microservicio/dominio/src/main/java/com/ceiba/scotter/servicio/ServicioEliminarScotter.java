package com.ceiba.scotter.servicio;

import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;

public class ServicioEliminarScotter {
    private final RepositorioScotter repositorioScotter;

    public ServicioEliminarScotter(RepositorioScotter repositorioScotter){
        this.repositorioScotter= repositorioScotter;
    }

    public void ejecutar(Long id){
        this.repositorioScotter.eliminar(id);
    }
}
