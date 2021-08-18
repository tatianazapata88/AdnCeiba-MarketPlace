package com.ceiba.scotter.comando.fabrica;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaScotter {

    private final RepositorioScotter repositorioScotter;

    public FabricaScotter(RepositorioScotter repositorioScotter) {
        this.repositorioScotter = repositorioScotter;
    }


    public Scotter crear(ComandoScotter comandoScotter) {
        Persona vendedor = repositorioScotter.obtenerPorId(comandoScotter.getId_vendedor());

        return new Scotter(
                comandoScotter.getId(),
                comandoScotter.getMarca(),
                comandoScotter.getModelo(),
                comandoScotter.getPrecio(),
                comandoScotter.getCiudad(),
                vendedor,
                //comandoScotter.getEstado(),
                comandoScotter.getFoto()
        );
    }
}
