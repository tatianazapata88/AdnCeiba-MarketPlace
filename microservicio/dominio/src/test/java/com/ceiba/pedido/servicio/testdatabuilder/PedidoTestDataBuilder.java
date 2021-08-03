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
    private double precio;





    public PedidoTestDataBuilder(){

        fecha = LocalDate.now();
        bici = 1L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000.0;





    }
    public PedidoTestDataBuilder(LocalDate fecha,Long bici, Long comprador, String ciudad,
                                 String destino, double precio) {
        this.fecha = fecha;
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

    public PedidoTestDataBuilder conBici(Long bici) {
        this.bici = bici;
        return this;
    }

    public PedidoTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;

        return this;
    }

    public PedidoTestDataBuilder conCiudadYDestino(String ciudad, String destino) {
        this.ciudad = ciudad;
        this.destino =destino;

        return this;
    }


    public Pedido build() {

        return new Pedido(id,fecha,bici,comprador,ciudad,destino,precio);
    }
}


