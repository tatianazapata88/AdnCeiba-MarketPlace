package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDate;

public class ComandoCompraTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador_id;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double precio;
    private double descuento;
    private double total;

    public ComandoCompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotter_id = 1L;
        comprador_id = 2L;
        ciudadDestinoEnvioScotter = "bogota";
    }

    public ComandoCompraTestDataBuilder(LocalDate fecha, Long scotter_id, Long comprador_id,
                                        String ciudadDestinoEnvioScotter, double flete, double precio, double descuento, double total) {
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador_id = comprador_id;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.flete = flete;
        this.precio = precio;
        this.descuento = descuento;
        this.total = total;
    }

    public ComandoCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id, fecha, scotter_id, comprador_id, ciudadDestinoEnvioScotter, flete, precio, descuento, total);
    }
}
