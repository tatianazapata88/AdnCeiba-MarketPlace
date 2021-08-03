package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorActualizarPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;
import com.ceiba.persona.comando.manejador.ManejadorEliminarPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador comando persona"})
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorEliminarPersona manejadorEliminarPersona;
    private final ManejadorActualizarPersona manejadorActualizarPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona,
                                     ManejadorEliminarPersona manejadorEliminarPersona, ManejadorActualizarPersona manejadorActualizarPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorEliminarPersona = manejadorEliminarPersona;
        this.manejadorActualizarPersona = manejadorActualizarPersona;
    }

    @PostMapping
    @ApiOperation("Crear Persona")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPersona comandoPersona) {
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Persona")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPersona.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Persona")
    public void actualizar(@RequestBody ComandoPersona comandoPersona, @PathVariable Long id) {
        comandoPersona.setId(id);
        manejadorActualizarPersona.ejecutar(comandoPersona);
    }
}
