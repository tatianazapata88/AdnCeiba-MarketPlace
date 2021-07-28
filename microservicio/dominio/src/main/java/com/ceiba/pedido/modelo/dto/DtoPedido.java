package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class DtoPedido {
    private Long id;
    private LocalDate fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private Integer flete;
    private Integer precio;
    private Integer descuento;
    private double total;
}
