package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.persona.adaptador.dao.MapeoPersonaObjeto;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.adaptador.dao.MapeoScotterObjeto;
import com.ceiba.scotter.adaptador.repositorio.RepositorioScotterMysql;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.lang.NullPointerException;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final RepositorioScotterMysql repositorioScotterMysql;

    @SqlStatement(namespace = "compra", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "compra", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "compra", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "compra", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "persona", value = "listar")
    private static String sqlListarPersona;

    @SqlStatement(namespace = "scotter", value = "listar")
    private static String sqlListarScotter;

    public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, RepositorioScotterMysql repositorioScotterMysql) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.repositorioScotterMysql = repositorioScotterMysql;
    }

    @Override
    public Long crear(Compra compra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", compra.getFecha());
        paramSource.addValue("scotter_id", compra.getScotter().getId());
        paramSource.addValue("comprador_id", compra.getComprador().getId());
        paramSource.addValue("ciudadDestinoEnvioScotter", compra.getCiudadDestinoEnvioScotter());
        paramSource.addValue("flete", compra.getFlete());
        paramSource.addValue("precio", compra.getScotter().getPrecio());
        paramSource.addValue("descuento", compra.getDescuento());
        paramSource.addValue("total", compra.getTotal());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        if (keyHolder.getKey() == null) {
            throw new NullPointerException();

        } else {
            return keyHolder.getKey().longValue();
        }
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Compra compra) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", compra.getId());
        paramSource.addValue("fecha", compra.getFecha());
        paramSource.addValue("scotter_id", compra.getScotter().getId());
        paramSource.addValue("comprador_id", compra.getComprador().getId());
        paramSource.addValue("ciudadDestinoEnvioScotter", compra.getCiudadDestinoEnvioScotter());
        paramSource.addValue("flete", compra.getFlete());
        paramSource.addValue("precio", compra.getScotter().getPrecio());
        paramSource.addValue("descuento", compra.getDescuento());
        paramSource.addValue("total", compra.getTotal());
        this.customNamedParameterJdbcTemplate.actualizar(compra, sqlActualizar);
    }

    @Override
    public boolean existe(Long scotter_id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("scotter_id", scotter_id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public Persona obtenerId(Long id) {
        return (Persona) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPersona, new MapeoPersonaObjeto()).get(0);
    }

    @Override
    public Scotter obtenerIdScotter(Long id) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarScotter, new MapeoScotterObjeto(repositorioScotterMysql)).get(0);
    }
}



