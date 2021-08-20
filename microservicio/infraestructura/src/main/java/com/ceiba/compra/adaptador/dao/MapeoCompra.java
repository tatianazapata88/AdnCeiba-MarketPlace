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
        Long scotterId = resultSet.getLong("scotterId");
        Long compradorId = resultSet.getLong("compradorId");
        String ciudadDestinoEnvioScotter = resultSet.getString("ciudadDestinoEnvioScotter");
        double flete = resultSet.getDouble("flete");
        double precio = resultSet.getDouble("precio");
        double descuento = resultSet.getDouble("descuento");
        double total = resultSet.getDouble("total");

        return new DtoCompra(id, fecha, scotterId, compradorId, ciudadDestinoEnvioScotter, flete, precio, descuento, total);
    }
}

