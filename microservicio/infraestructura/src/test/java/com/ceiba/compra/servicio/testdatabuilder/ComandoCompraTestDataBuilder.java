package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;

import java.time.LocalDate;

public class ComandoCompraTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador;
    private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
    private double precio;

    public ComandoCompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotter_id = 2L;
        comprador = 2L;
        ciudadoOrigenUbicacionScotter = "medellin";
        ciudadDestinoEnvioScotter = "bogota";
        precio = 4000000.0;
    }

    public ComandoCompraTestDataBuilder(LocalDate fecha, Long scotter_id, Long comprador, String ciudadoOrigenUbicacionScotter,
                                        String ciudadDestinoEnvioScotter, double precio) {
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador = comprador;
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.precio = precio;
    }

    public ComandoCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCompraTestDataBuilder conScotterId(Long scotter_id) {
        this.scotter_id = scotter_id;
        return this;
    }

    public ComandoCompraTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public ComandoCompraTestDataBuilder conCiudadOrigenYCiudadDestino(String ciudadoOrigenUbicacionScotter, String ciudadDestinoEnvioScotter) {
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        return this;
    }

    public ComandoCompra build() {
        return new ComandoCompra(id,fecha,scotter_id,comprador,ciudadoOrigenUbicacionScotter,ciudadDestinoEnvioScotter,precio);
    }
}
