package com.ceiba.scotter.comando.fabrica;

import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaScotter {
    public Scotter crear(ComandoScotter comandoScotter){
        return new Scotter(
                comandoScotter.getId(),
                comandoScotter.getMarca(),
                comandoScotter.getModelo(),
                comandoScotter.getPrecio(),
                comandoScotter.getCiudad(),
                comandoScotter.getVendedor(),
                comandoScotter.getFoto()
        );
    }
}
