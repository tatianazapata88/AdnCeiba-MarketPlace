package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;
import java.time.LocalDate;

public class CompraTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador;
    private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
   private double precio;

    public CompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotter_id = 1L;
        comprador = 2L;
        ciudadoOrigenUbicacionScotter = "medellin";
        ciudadDestinoEnvioScotter = "bogota";
        precio = 4000000.0;
    }

    public CompraTestDataBuilder(LocalDate fecha, Long scotter_id, Long comprador, String ciudadoOrigenUbicacionScotter,
                                 String ciudadDestinoEnvioScotter, double precio) {
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador = comprador;
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.precio = precio;
    }

    public CompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CompraTestDataBuilder conScotterId(Long scotter_id) {
        this.scotter_id = scotter_id;
        return this;
    }

    public CompraTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public CompraTestDataBuilder conCiudadOrigenYCiudadDestino(String ciudadoOrigenUbicacionScotter, String ciudadDestinoEnvioScotter) {
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        return this;
    }

    public Compra build() {
        return new Compra(id, fecha, scotter_id, comprador, ciudadoOrigenUbicacionScotter, ciudadDestinoEnvioScotter, precio);
    }
}


