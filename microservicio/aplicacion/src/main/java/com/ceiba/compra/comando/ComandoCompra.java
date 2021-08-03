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
    private Long scotter_id;
    private Long comprador;
    private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
    private double precio;
}
