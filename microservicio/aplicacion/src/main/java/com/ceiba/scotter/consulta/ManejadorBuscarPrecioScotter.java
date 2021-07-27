package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarPrecioScotter {

    private final DaoScotter daoScotter;

    public ManejadorBuscarPrecioScotter(DaoScotter daoScotter) {
        this.daoScotter = daoScotter;
    }

    public List<DtoScotter> ejecutar(Integer precio) {
        return this.daoScotter.buscarPrecio(precio);
    }
}
