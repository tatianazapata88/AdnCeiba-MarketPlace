package com.ceiba.compra.controlador;

import com.ceiba.compra.consulta.ManejadorListarCompra;
import com.ceiba.compra.modelo.dto.DtoCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
@Api(tags = {"Controlador consulta compras"})
public class ConsultaControladorCompra {

    private final ManejadorListarCompra manejadorListarCompra;

    public ConsultaControladorCompra(ManejadorListarCompra manejadorListarCompra) {
        this.manejadorListarCompra = manejadorListarCompra;
    }

    @GetMapping
    @ApiOperation("Listar compras")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompra.ejecutar();
    }
}
