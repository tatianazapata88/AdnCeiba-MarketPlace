package com.ceiba.scotter.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioScotterMysql implements RepositorioScotter {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="scotter", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="scotter", value="actualizar")
    private static String sqlActualizar;


    @SqlStatement(namespace="scotter", value="eliminar")
    private static String sqlEliminar;



    public RepositorioScotterMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;


    }

    @Override
    public Long crear(Scotter scotter) {
        return this.customNamedParameterJdbcTemplate.crear(scotter, sqlCrear);
    }

    @Override
    public void actualizar(Scotter scotter) {
        this.customNamedParameterJdbcTemplate.actualizar(scotter, sqlActualizar);

    }


    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }



}
