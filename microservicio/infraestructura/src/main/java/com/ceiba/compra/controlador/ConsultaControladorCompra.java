package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListarCompra;
import com.ceiba.compra.consulta.ManejadorListarIdCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags = {"Controlador consulta compras"})
public class ConsultaControladorCompra {

    private final ManejadorListarCompra manejadorListarCompra;
    private final ManejadorListarIdCompra manejadorListarIdCompra;

    public ConsultaControladorCompra(ManejadorListarCompra manejadorListarCompra, ManejadorListarIdCompra manejadorListarIdCompra) {
        this.manejadorListarCompra = manejadorListarCompra;
        this.manejadorListarIdCompra = manejadorListarIdCompra;
    }

    @GetMapping
    @ApiOperation("Listar compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompra.ejecutar();
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Listar compras por id")
    public DtoCompra listarId(@PathVariable Long id) {
        return this.manejadorListarIdCompra.ejecutar(id);
    }

}

