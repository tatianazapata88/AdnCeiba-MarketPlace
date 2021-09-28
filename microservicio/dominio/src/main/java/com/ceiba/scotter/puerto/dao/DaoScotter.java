package com.ceiba.scotter.puerto.dao;

import com.ceiba.scotter.modelo.dto.DtoScotter;

import java.util.List;

public interface DaoScotter {

    List<DtoScotter> listar();

    DtoScotter buscarId(Long id);

    List<DtoScotter> buscarIdVendedor(Long vendedor);

    List<DtoScotter> buscarCiudad(String ciudad);

    List<DtoScotter> buscarPrecio(double precio);


}
