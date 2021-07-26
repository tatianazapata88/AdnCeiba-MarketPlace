package com.ceiba.persona.consulta;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarIdPersona {
    private final DaoPersona daoPersona;

    public ManejadorListarIdPersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public DtoPersona ejecutar(Long id) {
        return this.daoPersona.listarId(id);
    }
}
