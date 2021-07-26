package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.dto.DtoPersona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult {

    @Override
    public DtoPersona mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String username = resultSet.getString("username");
        String nombre = resultSet.getString("nombre");
        String celular = resultSet.getString("celular");
        String email = resultSet.getString("email");

        return new DtoPersona(id, username, nombre, celular, email);
    }
}

