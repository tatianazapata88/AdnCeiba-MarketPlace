package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarIdScotter {


       private final DaoScotter daoScotter;

    public ManejadorBuscarIdScotter(DaoScotter daoScotter) {
        this.daoScotter = daoScotter;
    }

    public DtoScotter ejecutar(Long id){
        return this.daoScotter.buscarId(id);
    }

}

