package com.ceiba.scotter.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.comando.fabrica.FabricaScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.servicio.ServicioCrearScotter;

@Component
public class ManejadorCrearScotter  implements ManejadorComandoRespuesta<ComandoScotter, ComandoRespuesta<Long>> {
    private final FabricaScotter fabricaScotter;
    private final ServicioCrearScotter servicioCrearScotter;

    public ManejadorCrearScotter(FabricaScotter fabricaScotter, ServicioCrearScotter servicioCrearScotter) {
        this.fabricaScotter = fabricaScotter;
        this.servicioCrearScotter = servicioCrearScotter;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoScotter comandoScotter) {
        Scotter scotter = this.fabricaScotter.crear(comandoScotter);
        return new ComandoRespuesta<>(this.servicioCrearScotter.ejecutar(scotter));
    }
}
