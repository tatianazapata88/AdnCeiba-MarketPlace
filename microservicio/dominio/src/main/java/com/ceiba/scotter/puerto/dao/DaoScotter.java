package com.ceiba.scotter.puerto.dao;

import com.ceiba.scotter.modelo.dto.DtoScotter;

import java.util.List;

public interface DaoScotter {
    List<DtoScotter> listar();

   //DtoScotter buscar(Long id);

    DtoScotter buscarId(Long id);

    DtoScotter buscarCiudad(String ciudad);
}
