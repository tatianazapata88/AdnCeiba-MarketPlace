package com.ceiba.compra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.compra.modelo.dto.DtoCompra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

    @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        Long scotter_id = resultSet.getLong("scotter_id");
        Long comprador_id = resultSet.getLong("comprador_id");
       String ciudadDestinoEnvioScotter = resultSet.getString("ciudadDestinoEnvioScotter");
        double flete = resultSet.getDouble("flete");
        double precio = resultSet.getDouble("precio");
        double descuento = resultSet.getDouble("descuento");
        double total = resultSet.getDouble("total");

        return new DtoCompra(id, fecha, scotter_id, comprador_id, ciudadDestinoEnvioScotter, flete, precio, descuento, total);
    }
}

   /* @Override
    public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        Long scotter_id = resultSet.getLong("scotter_id");
        Long comprador = resultSet.getLong("comprador");
        String ciudadoOrigenUbicacionScotter = resultSet.getString("ciudadorigen");
        String ciudadDestinoEnvioScotter = resultSet.getString("ciudaddestino");
        double flete = resultSet.getDouble("flete");
        double precio = resultSet.getDouble("precio");
        double descuento = resultSet.getDouble("descuento");
        double total = resultSet.getDouble("total");

        return new DtoCompra(id, fecha, scotter_id, comprador, ciudadoOrigenUbicacionScotter, ciudadDestinoEnvioScotter, flete, precio, descuento, total);
    }*/
