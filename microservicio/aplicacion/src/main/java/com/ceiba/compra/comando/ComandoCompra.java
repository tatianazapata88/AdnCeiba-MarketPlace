package com.ceiba.compra.comando;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
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
 private Long comprador_id;
 private String ciudadDestinoEnvioScotter;
 private double flete;
 private double precio;
 private double descuento;
 private double total;

   /* private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador;
    private String ciudadDestinoEnvioScotter;
    private double precio;

    private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador_id;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double precio;
    private double descuento;
    private double total;
*/
}