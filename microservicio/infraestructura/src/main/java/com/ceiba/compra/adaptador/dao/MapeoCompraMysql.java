package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.adaptador.repositorio.RepositorioCompraMysql;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.adaptador.repositorio.RepositorioScotterMysql;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCompraMysql implements RowMapper<Compra>, MapperResult {

    private final RepositorioCompraMysql repositorioCompraMysql;

    public MapeoCompraMysql(RepositorioCompraMysql repositorioCompraMysql) {
        this.repositorioCompraMysql = repositorioCompraMysql;
    }

    @Override
    public Compra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        Long scotter_id = resultSet.getLong("scotter_id");
        Long comprador_id = resultSet.getLong("comprador_id");
        String ciudadDestinoEnvioScotter = resultSet.getString("ciudadDestinoEnvioScotter");
        double flete = resultSet.getDouble("flete");
        double precio = resultSet.getDouble("precio");
        double descuento = resultSet.getDouble("descuento");
        double total = resultSet.getDouble("total");

        Persona comprador= repositorioCompraMysql.obtenerId(comprador_id);
        Scotter scotter = repositorioCompraMysql.obtenerIdScotter(scotter_id);


        return new Compra(id, fecha, scotter, comprador, ciudadDestinoEnvioScotter);
    }

}
