package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    private final RepositorioPersona repositorioPersona;
    private final RepositorioScotter repositorioScotter;

    public FabricaCompra(RepositorioPersona repositorioPersona, RepositorioScotter repositorioScotter) {
        this.repositorioPersona = repositorioPersona;
        this.repositorioScotter = repositorioScotter;
    }

    public Compra crear(ComandoCompra comandoCompra) {
        Persona comprador = repositorioPersona.obtenerPersonaPorId(comandoCompra.getCompradorId());
        Scotter scotter = repositorioScotter.obtenerScotterPorId(comandoCompra.getScotterId());
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getFecha(),
                scotter,
                comprador,
                comandoCompra.getCiudadDestinoEnvioScotter());
    }
}
