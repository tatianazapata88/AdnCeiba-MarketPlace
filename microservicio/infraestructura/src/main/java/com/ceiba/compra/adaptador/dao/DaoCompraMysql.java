package com.ceiba.compra.adaptador.dao;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.persona.adaptador.dao.MapeoPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.adaptador.dao.MapeoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCompraMysql implements DaoCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "compra", value = "listar")
    private static String sqlListar;



    public DaoCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCompra());
    }


}
