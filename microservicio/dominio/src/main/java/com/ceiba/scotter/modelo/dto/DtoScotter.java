package com.ceiba.scotter.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoScotter {
    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private  String foto;
}
