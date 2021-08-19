package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDate;

public class ComandoCompraTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long scotterId;
    private Long compradorId;
    private String ciudadDestinoEnvioScotter;
    private double flete;
    private double precio;
    private double descuento;
    private double total;

    public ComandoCompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotterId = 1L;
        compradorId = 2L;
        ciudadDestinoEnvioScotter = "bogota";
    }

    public ComandoCompraTestDataBuilder(LocalDate fecha, Long scotterId, Long compradorId,
                                        String ciudadDestinoEnvioScotter, double flete, double precio, double descuento, double total) {
        this.fecha = fecha;
        this.scotterId = scotterId;
        this.compradorId = compradorId;
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
        return new ComandoCompra(id, fecha, scotterId, compradorId, ciudadDestinoEnvioScotter, flete, precio, descuento, total);
    }
}
