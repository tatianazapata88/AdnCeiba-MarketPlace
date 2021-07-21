package com.ceiba.pedido.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pedido {
    private static final String SE_DEBE_INGRESAR_LA_CIUDAD_DE_ENVIO = "Se debe ingresar la ciudad de envio";

    private Long id;
    private LocalDateTime fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private Integer flete;

    public Pedido(Long id, LocalDateTime fecha, Long bici, Long comprador, String ciudad, String destino, Integer flete) {
        validarObligatorio(ciudad, SE_DEBE_INGRESAR_LA_CIUDAD_DE_ENVIO);

        this.id = id;
        this.fecha = LocalDateTime.now();
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.flete = valorFlete(this.ciudad,this.destino);


    }

    private Integer valorFlete(String ciudad, String destino) {
        if (ciudad.equals(destino) ){
        return 0;}
        else{
            return 30000;
        }
    }
}



