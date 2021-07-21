package com.ceiba.scotter.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.comando.fabrica.FabricaScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.servicio.ServicioActualizarScotter;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarScotter implements ManejadorComando<ComandoScotter> {
private final FabricaScotter fabricaScotter;
private final ServicioActualizarScotter servicioActualizarScotter;

public ManejadorActualizarScotter(FabricaScotter fabricaScotter, ServicioActualizarScotter servicioActualizarScotter) {
        this.fabricaScotter = fabricaScotter;
        this.servicioActualizarScotter = servicioActualizarScotter;
        }

    @Override
        public void ejecutar(ComandoScotter comandoScotter) {
        Scotter scotter = this.fabricaScotter.crear(comandoScotter);
        this.servicioActualizarScotter.ejecutar(scotter);

        }
        }

