package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "compra", value = "crear")
    private static String sqlCrear;

     @SqlStatement(namespace = "compra", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "compra", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "compra", value = "reservarScotter")
    private static String sqlReservar;

    @SqlStatement(namespace = "compra", value = "disponibleScotter")
    private static String sqlDisponible;

    public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compra compra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", compra.getFecha());
        paramSource.addValue("scotterId", compra.getScotter().getId());
        paramSource.addValue("compradorId", compra.getComprador().getId());
        paramSource.addValue("ciudadDestinoEnvioScotter", compra.getCiudadDestinoEnvioScotter());
        paramSource.addValue("flete", compra.getFlete());
        paramSource.addValue("precio", compra.getScotter().getPrecio());
        paramSource.addValue("descuento", compra.getDescuento());
        paramSource.addValue("total", compra.getTotal());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlReservar, paramSource);
        return this.customNamedParameterJdbcTemplate.obtenerValueKey(keyHolder.getKey());
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(Long scotterId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("scotterId", scotterId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }
}



