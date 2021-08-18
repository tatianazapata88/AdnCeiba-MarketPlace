package com.ceiba.scotter.comando;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoScotter {
    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private String ciudad;
    private Long id_vendedor;
   // public Scotter.Estado estado;
    private String foto;
}
