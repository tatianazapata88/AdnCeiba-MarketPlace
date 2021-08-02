package com.ceiba.scotter.comando;

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
    private int precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private String foto;
}
