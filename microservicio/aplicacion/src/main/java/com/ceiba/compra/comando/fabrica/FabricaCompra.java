package com.ceiba.compra.comando.fabrica;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import org.springframework.stereotype.Component;

@Component
public class FabricaCompra {

    public Compra crear(ComandoCompra comandoCompra) {
        return new Compra(
                comandoCompra.getId(),
                comandoCompra.getFecha(),
                comandoCompra.getScotter_id(),
                comandoCompra.getComprador(),
                comandoCompra.getCiudadoOrigenUbicacionScotter(),
                comandoCompra.getCiudadDestinoEnvioScotter(),
                comandoCompra.getPrecio());
    }
}
