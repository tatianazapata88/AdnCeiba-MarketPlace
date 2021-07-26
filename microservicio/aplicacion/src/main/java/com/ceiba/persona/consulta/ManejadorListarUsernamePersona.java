package com.ceiba.persona.consulta;

import com.ceiba.persona.modelo.dto.DtoPersona;
import com.ceiba.persona.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarUsernamePersona {
    private final DaoPersona daoPersona;

    public ManejadorListarUsernamePersona(DaoPersona daoPersona) {
        this.daoPersona = daoPersona;
    }

    public DtoPersona ejecutar(String username) {
        return this.daoPersona.listarUsername(username);
    }
}
