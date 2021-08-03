package com.ceiba.scotter.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRelacionado;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;

public class ServicioEliminarScotter {

    private static final String SCOTTER_TIENE_REGISTRO_EN_UN_PEDIDO = "No se puede eliminar la scotter por que existe un registro con pedido";

    private final RepositorioScotter repositorioScotter;

    public ServicioEliminarScotter(RepositorioScotter repositorioScotter) {
        this.repositorioScotter = repositorioScotter;
    }

    public void ejecutar(Long id) {
        validarExistenciaPedido(id);
        this.repositorioScotter.eliminar(id);
    }

    private void validarExistenciaPedido(Long id) {
        boolean existeRegistroPedido = this.repositorioScotter.existePorPedido(id);
        if (existeRegistroPedido) {
            throw new ExcepcionRelacionado(SCOTTER_TIENE_REGISTRO_EN_UN_PEDIDO);
        }
    }
}
