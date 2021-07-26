package com.ceiba.persona.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.persona.servicio.ServicioEliminarPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPersona implements ManejadorComando<Long> {

    private final ServicioEliminarPersona servicioEliminarPersona;

    public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona) {
        this.servicioEliminarPersona = servicioEliminarPersona;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarPersona.ejecutar(id);
    }

}
