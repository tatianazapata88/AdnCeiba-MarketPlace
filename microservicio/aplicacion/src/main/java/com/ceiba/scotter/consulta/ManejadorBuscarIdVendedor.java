package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarIdVendedor {
    private final DaoScotter daoScotter;

    public ManejadorBuscarIdVendedor(DaoScotter daoScotter) {
        this.daoScotter = daoScotter;
    }

   /* public DtoScotter ejecutar(Long vendedor) {
        return this.daoScotter.buscarIdVendedor(vendedor);
            }*/

    public List<DtoScotter> ejecutar(Long vendedor) {
        return this.daoScotter.buscarIdVendedor(vendedor);
    }

}
