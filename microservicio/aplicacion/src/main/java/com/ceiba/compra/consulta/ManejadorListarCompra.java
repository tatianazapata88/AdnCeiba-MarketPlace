package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCompra {

    private final DaoCompra daoCompra;

    public ManejadorListarCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    public List<DtoCompra> ejecutar() {
        return this.daoCompra.listar();
    }
}
