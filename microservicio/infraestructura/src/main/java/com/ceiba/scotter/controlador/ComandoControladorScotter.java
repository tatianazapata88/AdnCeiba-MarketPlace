package com.ceiba.scotter.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.comando.manejador.ManejadorActualizarScotter;
import com.ceiba.scotter.comando.manejador.ManejadorCrearScotter;
import com.ceiba.scotter.comando.manejador.ManejadorEliminarScotter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scotters")
@Api(tags = { "Controlador comando scotter"})
public class ComandoControladorScotter {
    private final ManejadorCrearScotter manejadorCrearScotter;
    private final ManejadorEliminarScotter manejadorEliminarScotter;
    private final ManejadorActualizarScotter manejadorActualizarScotter;

    public ComandoControladorScotter(ManejadorCrearScotter manejadorCrearScotter,
                                     ManejadorEliminarScotter manejadorEliminarScotter,
                                     ManejadorActualizarScotter manejadorActualizarScotter) {
        this.manejadorCrearScotter = manejadorCrearScotter;
        this.manejadorEliminarScotter = manejadorEliminarScotter;
        this.manejadorActualizarScotter = manejadorActualizarScotter;
    }

    @PostMapping
    @ApiOperation("Crear Scotter")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoScotter comandoScotter) {
        return manejadorCrearScotter.ejecutar(comandoScotter);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Scotter")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarScotter.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Scotter")
    public void actualizar(@RequestBody ComandoScotter comandoScotter,@PathVariable Long id) {
        comandoScotter.setId(id);
        manejadorActualizarScotter.ejecutar(comandoScotter);
    }
}
