package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador;
    private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double precio;
    private double descuento;
    private double total;
}
