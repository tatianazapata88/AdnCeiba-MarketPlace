package com.ceiba.scotter.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.adaptador.dao.MapeoPersonaObjeto;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.util.Objects;

@Repository
public class RepositorioScotterMysql implements RepositorioScotter {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "scotter", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "scotter", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "scotter", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "persona", value = "existePorPedido")
    private static String sqlExistePorPedido;

    @SqlStatement(namespace = "persona", value = "listar")
    private static String sqlListarPersona;

    public RepositorioScotterMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Scotter scotter) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("marca", scotter.getMarca());
        paramSource.addValue("modelo", scotter.getModelo());
        paramSource.addValue("precio", scotter.getPrecio());
        paramSource.addValue("ciudad", scotter.getCiudad());
        paramSource.addValue("vendedor", scotter.getVendedor().getId());
        paramSource.addValue("estado", scotter.getEstado().toString());
        paramSource.addValue("foto", scotter.getFoto());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        Number objectKeyHolder = keyHolder.getKey();
        if (Objects.isNull(objectKeyHolder)){
            throw new NullPointerException();
        } else {
            return objectKeyHolder.longValue();
        }
    }

    @Override
    public void actualizar(Scotter scotter) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", scotter.getId());
        paramSource.addValue("marca", scotter.getMarca());
        paramSource.addValue("modelo", scotter.getModelo());
        paramSource.addValue("precio", scotter.getPrecio());
        paramSource.addValue("ciudad", scotter.getCiudad());
        paramSource.addValue("vendedor", scotter.getVendedor().getId());
        paramSource.addValue("estado", scotter.getEstado().toString());
        paramSource.addValue("foto", scotter.getFoto());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorPedido(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorPedido, parameterSource, Boolean.class);
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPersona, new MapeoPersonaObjeto()).get(0);
    }
}
