package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

import java.time.LocalDate;

public class ComandoPedidoTestDataBuilder {
    private Long id;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private int precio;




    public ComandoPedidoTestDataBuilder(){

        bici = 1L;
        comprador = 2L;
        ciudad = "medellin";
        destino = "bogota";
        precio = 4000000;

       // total= 4030000;

    }
    public ComandoPedidoTestDataBuilder(Long bici, Long comprador, String ciudad,
                                 String destino, int precio) {
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.precio = precio;

    }

    public ComandoPedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }



    public ComandoPedidoTestDataBuilder conCiudadYDestino(String ciudad, String destino) {
        this.ciudad = ciudad;
        this.destino =destino;

        return this;
    }


    public ComandoPedido build() {

        return new ComandoPedido(id,bici,comprador,ciudad,destino,precio);
    }
}
