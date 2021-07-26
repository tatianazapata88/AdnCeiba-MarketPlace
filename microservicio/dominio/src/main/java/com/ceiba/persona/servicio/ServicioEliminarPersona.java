package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionRelacionado;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioEliminarPersona {

    private static final String PERSONA_TIENE_REGISTRO_EN_UN_PEDIDO = "No se puede eliminar la persona por que existe un registro con pedido";

    private final RepositorioPersona repositorioPersona;

    public ServicioEliminarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Long id) {
        validarExistenciaPedido(id);
        this.repositorioPersona.eliminar(id);
    }

    private void validarExistenciaPedido(Long id) {
        boolean existeRegistroPedido = this.repositorioPersona.existePorPedido(id);
        if (existeRegistroPedido) {
            throw new ExcepcionRelacionado(PERSONA_TIENE_REGISTRO_EN_UN_PEDIDO);
        }
    }
}
