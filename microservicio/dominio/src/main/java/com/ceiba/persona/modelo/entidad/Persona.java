package com.ceiba.persona.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import lombok.Getter;

@Getter
public class Persona {

    private static final String CAMPO_USERNAME_ES_OBLIGATORIO = "El campo username obligatorio no puede ir vacio";
    private static final String CAMPO_NOMBRE_ES_OBLIGATORIO = "El campo nombre es obligatorio no puede ir vacio";
    private static final String CAMPO_CELULAR_ES_OBLIGATORIO = "El campo celular es obligatorio no puede ir vacio";
    private static final String CAMPO_EMAIL_ES_OBLIGATORIO = "El campo email es obligatorio no puede ir vacio";

    private Long id;
    private String username;
    private String nombre;
    private String celular;
    private String email;

    public Persona(Long id, String username, String nombre, String celular, String email) {
        this.validarCampoUsernameVacio(username);
        this.validarCampoNombreVacio(nombre);
        this.validarCampoCelularVacio(celular);
        this.validarCampoEmailVacio(email);
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
    }

    private void validarCampoUsernameVacio(String username) {
        if (username == null || username.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_USERNAME_ES_OBLIGATORIO);
        }
    }

    private void validarCampoNombreVacio(String nombre) {
        if (nombre == null || nombre.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_NOMBRE_ES_OBLIGATORIO);
        }
    }

    private void validarCampoCelularVacio(String celular) {
        if (celular == null || celular.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CELULAR_ES_OBLIGATORIO);
        }
    }

    private void validarCampoEmailVacio(String email) {
        if (email == null || email.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_EMAIL_ES_OBLIGATORIO);
        }
    }
}
