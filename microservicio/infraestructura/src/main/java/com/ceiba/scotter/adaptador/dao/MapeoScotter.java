package com.ceiba.scotter.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.scotter.modelo.dto.DtoScotter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoScotter implements RowMapper<DtoScotter>, MapperResult {

    @Override
    public DtoScotter mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String marca = resultSet.getString("marca");
        String modelo = resultSet.getString("modelo");
        Integer precio = resultSet.getInt("precio");
        String ciudad = resultSet.getString("ciudad");
        Long vendedor = resultSet.getLong("vendedor");
        String estado =resultSet.getString("estado");
        String foto =  resultSet.getString("foto");


        return new DtoScotter(id, marca, modelo, precio, ciudad, vendedor, estado, foto);
    }
}
