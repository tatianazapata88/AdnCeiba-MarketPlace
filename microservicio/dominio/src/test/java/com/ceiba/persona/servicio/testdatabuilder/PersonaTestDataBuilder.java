package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {
    private Long id;
    private String username;
    private String nombre;
    private String celular;
    private String email;

    public PersonaTestDataBuilder(){
        username = "taty";
        nombre="Luz Tatiana Zapata";
        celular="3135151617";
        email="tatianazz3@hotmail.com";
    }


    public PersonaTestDataBuilder(String username, String nombre, String celular, String email) {
        this.username = username;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
    }

    public PersonaTestDataBuilder conUsername(String username){
        this.username=username;
        return this;
    }

    public PersonaTestDataBuilder conId(Long id){
        this.id = id;
        return this;

    }

    public Persona build() {
        return new Persona(id, username, nombre, celular, email);
    }
}
