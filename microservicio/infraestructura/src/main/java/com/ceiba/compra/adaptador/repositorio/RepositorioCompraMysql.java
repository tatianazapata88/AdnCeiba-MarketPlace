package com.ceiba.compra.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompraMysql implements RepositorioCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "compra", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "compra", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "compra", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "compra", value = "existe")
    private static String sqlExiste;

    /*@SqlStatement(namespace = "pedido", value = "reservarScotter")
    private static String sqlEstadoScotter;*/

    public RepositorioCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compra compra) {
        return this.customNamedParameterJdbcTemplate.crear(compra, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Compra compra) {
        this.customNamedParameterJdbcTemplate.actualizar(compra, sqlActualizar);
    }

    @Override
    public boolean existe(Long scotter_id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("scotter_id", scotter_id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }
}
   /* @Override
    public void cambiarEstado(Long bici) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", bici);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEstadoScotter, paramSource);
    }*/


