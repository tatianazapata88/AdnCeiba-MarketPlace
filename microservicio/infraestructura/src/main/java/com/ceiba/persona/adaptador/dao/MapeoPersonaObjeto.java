package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPersonaObjeto implements RowMapper<Persona>, MapperResult {

    @Override
    public Persona mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String username = resultSet.getString("username");
        String nombre = resultSet.getString("nombre");
        String celular = resultSet.getString("celular");
        String email = resultSet.getString("email");
        return new Persona(id, username, nombre, celular, email);
    }
}