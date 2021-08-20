package com.ceiba.scotter.comando.fabrica;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaScotter {

    private final RepositorioPersona repositorioPersona;

    public FabricaScotter(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public Scotter crear(ComandoScotter comandoScotter) {
        Persona vendedor = repositorioPersona.obtenerPersonaPorId(comandoScotter.getId_vendedor());

        return new Scotter(
                comandoScotter.getId(),
                comandoScotter.getMarca(),
                comandoScotter.getModelo(),
                comandoScotter.getPrecio(),
                comandoScotter.getCiudad(),
                vendedor,
                comandoScotter.getFoto()
        );
    }
}
