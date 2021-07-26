package com.ceiba.pedido.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
public class Pedido {
    private static final String SE_DEBE_INGRESAR_LA_CIUDAD_DE_ENVIO = "Se debe ingresar la ciudad de envio";
    private static final String CAMPO_BICI_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_DESTINO_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_FLETE_ES_OBLIGATORIO = "El campo flete  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";
    private static final String CAMPO_DESCUENTO_ES_OBLIGATORIO = "El campo descuento  es obligatorio no puede ir vacio";
    private static final String CAMPO_TOTAL_ES_OBLIGATORIO = "El campo total  es obligatorio no puede ir vacio";

    private Long id;
    private LocalDate fecha;
    private Long bici;
    private Long comprador;
    private String ciudad;
    private String destino;
    private double flete;
    private double precio;
    private double descuento;
    private double total;

    public Pedido(Long id, LocalDate fecha, Long bici, Long comprador, String ciudad, String destino, double flete, double precio, double descuento, double total) {
        validarCampoBici(bici);
        validarCampoComprador(comprador);
        validarCampoCiudad(ciudad);
        validarCampoDestino(destino);
        validarCampoFlete(flete);
        validarCampoPrecio(precio);
        validarCampoDescuento(descuento);
        validarCampoTotal(total);


        this.id = id;
        this.fecha = fecha;
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.flete = valorFlete(this.ciudad,this.destino);
        this.precio= precio;
        this.descuento = valorDescuento(this.fecha, this.precio);
        this.total = valorTotal(this.precio,this.flete,this.descuento);


    }

    private void validarCampoBici(Long bici){
        if (bici == null) {
            throw new ExcepcionValorObligatorio(CAMPO_BICI_ES_OBLIGATORIO);
        }
    }

    private void validarCampoComprador(Long comprador){
        if (comprador == null) {
            throw new ExcepcionValorObligatorio(CAMPO_COMPRADOR_ES_OBLIGATORIO);
        }
    }

    private void validarCampoCiudad(String ciudad){
        if (ciudad == null) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_ES_OBLIGATORIO);
        }
    }

    private void validarCampoDestino(String destino){
        if (destino == null) {
            throw new ExcepcionValorObligatorio(CAMPO_DESTINO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoFlete(double flete){
        int fleteInt = (int) flete;
        Integer flete1 = Integer.valueOf(fleteInt);
           if (flete1 == null) {
            throw new ExcepcionValorObligatorio(CAMPO_FLETE_ES_OBLIGATORIO);
        }
    }

    private void validarCampoPrecio(double precio){
        int precioInt = (int) precio;
        Integer precio1 = Integer.valueOf(precioInt);
        if (precio1 == null) {
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoDescuento(double descuento){
        int descuentoInt = (int) descuento;
        Integer descuento1 = Integer.valueOf(descuentoInt);
        if (descuento1 == null) {
            throw new ExcepcionValorObligatorio(CAMPO_DESCUENTO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoTotal(double total){
        int totalInt = (int) total;
        Integer total1 = Integer.valueOf(totalInt);
        if (total1 == null) {
            throw new ExcepcionValorObligatorio(CAMPO_TOTAL_ES_OBLIGATORIO);
        }
    }

    private double valorTotal(double precio, double flete, double descuento) {
        return Math.round(precio + flete - descuento);
    }

    private double valorDescuento(LocalDate fecha, double precio) {
        if (fecha == LocalDate.now())
        { return Math.round(precio*0.05);}
        else{
            return 0;
        }

    }

    private double valorFlete(String ciudad, String destino) {
        if (ciudad.equals(destino) ){
        return 0;}
        else{
            return 30000;
        }
    }
}



