package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarScotter {
    private final DaoScotter daoScotter;

    public ManejadorListarScotter(DaoScotter daoScotter) {
        this.daoScotter = daoScotter;
    }

    //public List<DtoScotter> ejecutar(){
      //  return  this.daoScotter.listar(String estado);
    //}
}
