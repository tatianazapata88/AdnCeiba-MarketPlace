package com.ceiba.scotter.controlador;

import com.ceiba.scotter.consulta.ManejadorListarScotter;
import com.ceiba.scotter.modelo.dto.DtoScotter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scotters")
@Api(tags={"Controlador consulta scotter"})
public class ConsultaControladorScotter {
    private final ManejadorListarScotter manejadorListarScotter;


    public ConsultaControladorScotter(ManejadorListarScotter manejadorListarScotter) {
        this.manejadorListarScotter = manejadorListarScotter;
    }

   // @GetMapping
    //@ApiOperation("Listar Scotter")
   // public List<DtoScotter> listar(String estado){
     //   return this.manejadorListarScotter.ejecutar();
    //}
}
