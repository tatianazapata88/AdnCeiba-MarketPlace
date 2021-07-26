package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

    private RepositorioPersona repositorioPersona;

    private static final String USERNAME_YA_REGISTRADO_EN_EL_SISTEMA = "No se puede registrar la persona por que ya existe el username";

    public ServicioCrearPersona(RepositorioPersona repositorioPersona) {

        this.repositorioPersona = repositorioPersona;
    }

    public Long ejecutar(Persona persona) {
        validarExistenciaUsername(persona);
        return this.repositorioPersona.crear(persona);
    }

    private void validarExistenciaUsername(Persona persona) {
        boolean existeUsername = this.repositorioPersona.existe(persona.getUsername());
        if (existeUsername) {
            throw new ExcepcionDuplicidad(USERNAME_YA_REGISTRADO_EN_EL_SISTEMA);
        }
    }
}

