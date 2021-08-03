package com.ceiba.scotter.servicio;

import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;

public class ServicioActualizarScotter {

    private final RepositorioScotter repositorioScotter;

    public ServicioActualizarScotter(RepositorioScotter repositorioScotter) {
        this.repositorioScotter = repositorioScotter;
    }

    public void ejecutar(Scotter scotter) {
        this.repositorioScotter.actualizar(scotter);
    }
}
