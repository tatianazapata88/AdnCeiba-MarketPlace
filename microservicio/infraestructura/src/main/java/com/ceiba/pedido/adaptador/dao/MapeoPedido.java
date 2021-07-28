package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha");
        Long bici = resultSet.getLong("bici");
        Long comprador = resultSet.getLong("comprador");
        String ciudad = resultSet.getString("ciudad");
        String destino = resultSet.getString("destino");
        int flete = resultSet.getInt("flete");
        int precio = resultSet.getInt("precio");
        int descuento = resultSet.getInt("descuento");
        int total = resultSet.getInt("total");



        return new DtoPedido(id,fecha,bici,comprador,ciudad,destino,flete,precio,descuento,total);
    }

}
