package com.ceiba.persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPersona {
    private Long id;
    private String username;
    private String nombre;
    private String celular;
    private String email;
}
