package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;


import java.time.LocalDate;

public class PedidoTestDataBuilder {
    private Long id;
    private LocalDate fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private int flete;
    private int precio;
    private int descuento;
    private int total;




    public PedidoTestDataBuilder(){


        bici = 1L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000;





    }
    public PedidoTestDataBuilder(LocalDate fecha, Long bici, Long comprador, String ciudad,
                                 String destino, int precio) {
        this.fecha = LocalDate.now();
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.precio = precio;

    }

    public PedidoTestDataBuilder conId(Long id) {
     this.id = id;
        return this;
    }

    public PedidoTestDataBuilder conFecha(LocalDate fecha1) {
        this.fecha = fecha1;

        return this;
    }

    public PedidoTestDataBuilder conCiudadYDestino(String ciudad, String destino) {
        this.ciudad = ciudad;
        this.destino =destino;

        return this;
    }

    public PedidoTestDataBuilder conFletePrecioYDescuento( int precio,int flete, int descuento){
        this.flete = flete;
        this.precio =precio;
        this.descuento=descuento;

        return  this;
    }

    public Pedido build() {

        return new Pedido(id,fecha,bici,comprador,ciudad,destino,flete,precio,descuento,total);
    }
}


