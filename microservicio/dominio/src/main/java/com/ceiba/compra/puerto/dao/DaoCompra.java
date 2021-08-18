package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;


import java.util.List;

public interface DaoCompra {

    List<DtoCompra> listar();

}
