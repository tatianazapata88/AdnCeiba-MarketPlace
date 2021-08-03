package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.ComandoPersona;

public class ComandoPersonaTestDataBuilder {
    private Long id;
    private String username;
    private String nombre;
    private String celular;
    private String email;

    public ComandoPersonaTestDataBuilder() {
        username = "jose";
        nombre = "Jose Arturo Oswaldo";
        celular = "3142644081";
        email = "jose@gmail.com";
    }

    public ComandoPersonaTestDataBuilder conUsernameAndNombre(String username, String nombre) {
        this.nombre = nombre;
        this.username = username;
        return this;
    }

    public ComandoPersonaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPersona build() {
        return new ComandoPersona(id, username, nombre, celular, email);
    }
}

