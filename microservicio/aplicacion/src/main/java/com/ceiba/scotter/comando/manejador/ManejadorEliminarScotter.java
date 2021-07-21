package com.ceiba.scotter.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.scotter.servicio.ServicioEliminarScotter;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarScotter implements ManejadorComando<Long> {
    private final ServicioEliminarScotter servicioEliminarScotter;

    public ManejadorEliminarScotter(ServicioEliminarScotter servicioEliminarScotter) {
        this.servicioEliminarScotter = servicioEliminarScotter;
    }

    public void ejecutar(Long id){
        this.servicioEliminarScotter.ejecutar(id);
    }
}
