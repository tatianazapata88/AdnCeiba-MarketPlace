package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearCompra {

    private final RepositorioCompra repositorioCompra;


    private static final String NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA = "No se puede registrar el pedido, la scotter ya se encuentra reservada";

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;

    }

    public Long ejecutar(Compra compra) {
        validarExistenciaCompra(compra);
        return this.repositorioCompra.crear(compra);
    }

    private void validarExistenciaCompra(Compra compra) {
        boolean existeCompra = this.repositorioCompra.existe(compra.getScotter().getId());
        if (existeCompra) {
            throw new ExcepcionDuplicidad(NO_SE_PUEDE_REGISTRAR_PEDIDO_SCOTTER_YA_ESTA_RESERVADA);
        }
    }
}
