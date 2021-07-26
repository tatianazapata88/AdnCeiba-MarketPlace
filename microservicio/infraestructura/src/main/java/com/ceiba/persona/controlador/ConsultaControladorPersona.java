package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ManejadorListarIdPersona;
import com.ceiba.persona.consulta.ManejadorListarPersona;
import com.ceiba.persona.consulta.ManejadorListarUsernamePersona;
import com.ceiba.persona.modelo.dto.DtoPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador consulta persona"})
public class ConsultaControladorPersona {
    private final ManejadorListarPersona manejadorListarPersona;
    private final ManejadorListarIdPersona manejadorListarIdPersona;
    private final ManejadorListarUsernamePersona manejadorListarUsernamePersona;

    public ConsultaControladorPersona(ManejadorListarPersona manejadorListarPersona, ManejadorListarIdPersona manejadorListarIdPersona, ManejadorListarUsernamePersona manejadorListarUsernamePersona) {
        this.manejadorListarPersona = manejadorListarPersona;
        this.manejadorListarIdPersona = manejadorListarIdPersona;
        this.manejadorListarUsernamePersona = manejadorListarUsernamePersona;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<DtoPersona> listar(){
        return this.manejadorListarPersona.ejecutar();
    }

    @GetMapping("/id/{id}")
    @ApiOperation("Listar Personas por id")
    public DtoPersona listar(@PathVariable Long id){
        return this.manejadorListarIdPersona.ejecutar(id);
    }

    @GetMapping("/username/{username}")
    @ApiOperation("Listar Personas por username")
    public DtoPersona listar(@PathVariable String username){
        return this.manejadorListarUsernamePersona.ejecutar(username);
    }
}
