package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    private final RepositorioCompra repositorioCompra;

    public FabricaCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public Compra crear(ComandoCompra comandoCompra) {
        Persona comprador = repositorioCompra.obtenerId(comandoCompra.getComprador_id());
        Scotter scotter = repositorioCompra.obtenerIdScotter(comandoCompra.getScotter_id());
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getFecha(),
                scotter,
                comprador,
                comandoCompra.getCiudadDestinoEnvioScotter());
    }
}
