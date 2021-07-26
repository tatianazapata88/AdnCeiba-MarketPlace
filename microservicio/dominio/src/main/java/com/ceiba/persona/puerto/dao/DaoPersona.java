package com.ceiba.persona.puerto.dao;

import com.ceiba.persona.modelo.dto.DtoPersona;

import java.util.List;

public interface DaoPersona {

    List<DtoPersona> listar();
    DtoPersona listarId(Long id);
    DtoPersona listarUsername(String Username);
}
