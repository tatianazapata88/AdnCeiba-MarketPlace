package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;

import java.time.LocalDate;

public class CompraTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    public Scotter scotter;
    public Persona comprador;
    private String ciudadDestinoEnvioScotter;

    public CompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotter = new Scotter(1L, "honda", "2021", 1000000, "medellin", new Persona(1l, "taty", "Luz Tatiana", "3135151617", "taty@gmail.com"), "esta");
        comprador = new Persona(2l, "salo", "salome agudelo", "3003680128", "salo@gmail.com");
        ciudadDestinoEnvioScotter = "bogota";

    }

    public CompraTestDataBuilder(LocalDate fecha, Scotter scotter, Persona comprador,
                                 String ciudadDestinoEnvioScotter) {
        this.fecha = fecha;
        this.scotter = scotter;
        this.comprador = comprador;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
    }

    public CompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CompraTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public CompraTestDataBuilder conCiudadDestino(String ciudadDestinoEnvioScotter) {
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        return this;
    }

    public Compra build() {
        return new Compra(id, fecha, scotter, comprador, ciudadDestinoEnvioScotter);
    }
}


