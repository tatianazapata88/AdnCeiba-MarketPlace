package com.ceiba.persona.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPersona {
    private Long id;
    private String username;
    private String nombre;
    private String celular;
    private String email;
}
