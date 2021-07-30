package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;


import java.time.LocalDate;

public class PedidoTestDataBuilder {
    private Long id;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private int precio;





    public PedidoTestDataBuilder(){


        bici = 1L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000;





    }
    public PedidoTestDataBuilder(Long bici, Long comprador, String ciudad,
                                 String destino, int precio) {

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

    /*public PedidoTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;

        return this;
    }*/

    public PedidoTestDataBuilder conCiudadYDestino(String ciudad, String destino) {
        this.ciudad = ciudad;
        this.destino =destino;

        return this;
    }


    public Pedido build() {

        return new Pedido(id,bici,comprador,ciudad,destino,precio);
    }
}


