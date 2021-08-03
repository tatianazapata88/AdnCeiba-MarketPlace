package com.ceiba.persona.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.persona.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoPersona, ComandoRespuesta<Long>> {

    private final FabricaPersona fabricaPersona;
    private final ServicioCrearPersona servicioCrearPersona;

    public ManejadorCrearPersona(FabricaPersona fabricaPersona, ServicioCrearPersona servicioCrearPersona) {
        this.fabricaPersona = fabricaPersona;
        this.servicioCrearPersona = servicioCrearPersona;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPersona comandoPersona) {
        Persona persona = this.fabricaPersona.crear(comandoPersona);
        return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(persona));
    }
}
