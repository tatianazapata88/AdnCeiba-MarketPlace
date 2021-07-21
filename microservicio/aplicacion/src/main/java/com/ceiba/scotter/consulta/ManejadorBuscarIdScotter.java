package com.ceiba.scotter.consulta;

import com.ceiba.scotter.modelo.dto.DtoScotter;
import com.ceiba.scotter.puerto.dao.DaoScotter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarIdScotter {


        @Autowired
        private DaoScotter daoScotter;

        public DtoScotter buscarId(Long id) {
            return daoScotter.buscarId(id);
        }

    }

