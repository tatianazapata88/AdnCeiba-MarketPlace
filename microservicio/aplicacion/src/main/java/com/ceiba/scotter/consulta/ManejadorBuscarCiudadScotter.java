package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarCiudadScotter {
    private final DaoScotter daoScotter;

    public ManejadorBuscarCiudadScotter(DaoScotter daoScotter) {
        this.daoScotter = daoScotter;
    }

    public List<DtoScotter> ejecutar(String ciudad) {
        return this.daoScotter.buscarCiudad(ciudad);
    }
}
