package com.ceiba.scotter.controlador;

import com.ceiba.scotter.consulta.ManejadorBuscarIdScotter;
import com.ceiba.scotter.consulta.ManejadorListarScotter;
import com.ceiba.scotter.modelo.dto.DtoScotter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scotters")
@Api(tags={"Controlador consulta scotter"})
public class ConsultaControladorScotter {
    private final ManejadorBuscarIdScotter manejadorBuscarIdScotter;

    public ConsultaControladorScotter(ManejadorBuscarIdScotter manejadorBuscarIdScotter) {
        this.manejadorBuscarIdScotter = manejadorBuscarIdScotter;
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Listar scotters por id")
    public DtoScotter listar(@PathVariable Long id){
        return this.manejadorBuscarIdScotter.ejecutar(id);
    }
}
