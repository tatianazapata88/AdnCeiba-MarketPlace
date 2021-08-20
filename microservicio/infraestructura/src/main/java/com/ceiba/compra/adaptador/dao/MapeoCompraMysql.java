package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaMysql;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.adaptador.repositorio.RepositorioScotterMysql;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCompraMysql implements RowMapper<Compra>, MapperResult {

    private final RepositorioPersonaMysql repositorioPersonaMysql;
    private final RepositorioScotterMysql repositorioScotterMysql;

    public MapeoCompraMysql(RepositorioPersonaMysql repositorioPersonaMysql, RepositorioScotterMysql repositorioScotterMysql) {
        this.repositorioPersonaMysql = repositorioPersonaMysql;
        this.repositorioScotterMysql = repositorioScotterMysql;
    }

    @Override
    public Compra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        Long scotterId = resultSet.getLong("scotterId");
        Long compradorId = resultSet.getLong("compradorId");
        String ciudadDestinoEnvioScotter = resultSet.getString("ciudadDestinoEnvioScotter");
        double flete = resultSet.getDouble("flete");
        double precio = resultSet.getDouble("precio");
        double descuento = resultSet.getDouble("descuento");
        double total = resultSet.getDouble("total");

        Persona comprador = repositorioPersonaMysql.obtenerPersonaPorId(compradorId);
        Scotter scotter = repositorioScotterMysql.obtenerScotterPorId(scotterId);

        return new Compra(id, fecha, scotter, comprador, ciudadDestinoEnvioScotter);
    }
}
