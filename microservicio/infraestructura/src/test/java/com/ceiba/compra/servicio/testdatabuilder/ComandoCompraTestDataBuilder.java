package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;

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


   /* private Long id;
    private LocalDate fecha;
    private Long scotter_id;
    private Long comprador;
    private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
    private double precio;*/

    public ComandoCompraTestDataBuilder() {
        fecha = LocalDate.now();
        scotter_id = 1L;
        comprador_id = 1L;

        ciudadDestinoEnvioScotter = "bogota";
       /* flete=30000.0;
        precio=1000000.0;
        descuento=0.00;
        total=1030000.0;*/
    }

    public ComandoCompraTestDataBuilder(LocalDate fecha, Long scotter_id, Long comprador_id,
                                        String ciudadDestinoEnvioScotter, double flete, double precio, double descuento,double total) {
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador_id = comprador_id;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.flete=flete;
        this.precio=precio;
        this.descuento=descuento;
        this.total=total;
    }

   /* public ComandoCompraTestDataBuilder(LocalDate fecha, Long scotter_id, Long comprador, String ciudadoOrigenUbicacionScotter,
                                        String ciudadDestinoEnvioScotter, double precio) {
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador = comprador;
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.precio = precio;
    }*/


    public ComandoCompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

   /* public ComandoCompraTestDataBuilder conScotterId(Long scotter_id) {
        this.scotter.getId() = scotter_id;
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
    }*/

    public ComandoCompra build() {

        return new ComandoCompra(id,fecha,scotter_id,comprador_id,ciudadDestinoEnvioScotter, flete, precio,descuento,total);
    }
}
