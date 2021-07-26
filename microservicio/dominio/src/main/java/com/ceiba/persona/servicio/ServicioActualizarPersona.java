package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioActualizarPersona {
    private static final String USERNAME_YA_REGISTRADO_EN_EL_SISTEMA = "No se puede registrar la persona por que ya existe el username";

    private final RepositorioPersona repositorioPersona;

    public ServicioActualizarPersona(RepositorioPersona repositorioPersona) {
        this.repositorioPersona = repositorioPersona;
    }

    public void ejecutar(Persona persona) {
        validarExistenciaUsername(persona);
        this.repositorioPersona.actualizar(persona);
    }

    private void validarExistenciaUsername(Persona persona) {
        boolean existeRegistroUsername = this.repositorioPersona.existePorActualizar(persona.getUsername(),persona.getId());
        if (existeRegistroUsername) {
            throw new ExcepcionDuplicidad(USERNAME_YA_REGISTRADO_EN_EL_SISTEMA);
        }
    }

}
