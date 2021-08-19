package com.ceiba.compra.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ComandoCompra {
    private Long id;
    private LocalDate fecha;
    private Long scotterId;
    private Long compradorId;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double precio;
    private double descuento;
    private double total;
}