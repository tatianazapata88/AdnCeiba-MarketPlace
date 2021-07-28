package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.scotter.modelo.entidad.Scotter;

import java.time.LocalDate;

public class PedidoTestDataBuilder {
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

    public PedidoTestDataBuilder(){

        fecha= LocalDate.ofEpochDay(2021-07-07);
        bici = 1L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000;
        flete =30000;
        descuento = 0;
        total = 4030000;
    }
    public PedidoTestDataBuilder(LocalDate fecha, Long bici, Long comprador, String ciudad,
                                 String destino, Integer flete, Integer precio, Integer descuento, double total) {
        this.fecha = fecha;
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.flete = flete;
        this.precio = precio;
        this.descuento = descuento;
        this.total = total;
    }

    public PedidoTestDataBuilder conId(Long id) {
     this.id = id;
        return this;
    }

    public PedidoTestDataBuilder conDescuento(LocalDate fecha, Integer descuento) {
        this.fecha = fecha;
        this.descuento=descuento;
        return this;
    }

    public Pedido build() {

        return new Pedido(id,fecha,bici,comprador,ciudad,destino,flete,precio,descuento,total);
    }
}


