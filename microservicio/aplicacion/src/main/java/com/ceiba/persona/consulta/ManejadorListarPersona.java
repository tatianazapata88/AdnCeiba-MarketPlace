package com.ceiba.persona.consulta;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPersona {

    private final DaoPersona daoPersona;

    public ManejadorListarPersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public List<DtoPersona> ejecutar() {
        return this.daoPersona.listar();
    }
}
