package com.ceiba.compra.consulta;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorListarIdCompra {
    private final DaoCompra daoCompra;

    public ManejadorListarIdCompra(DaoCompra daoCompra) {
        this.daoCompra = daoCompra;
    }

    public DtoCompra ejecutar(Long id) {
        return this.daoCompra.listarId(id);
    }
}
