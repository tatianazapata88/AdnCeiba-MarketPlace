package com.ceiba.pedido.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;


@Getter
public class Pedido {

    private static final String CAMPO_BICI_ES_OBLIGATORIO = "El campo scotter obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_DESTINO_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";


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

    public Pedido(Long id, LocalDate fecha, Long bici, Long comprador, String ciudad, String destino, int precio) {
        validarCampoBici(bici);
        validarCampoComprador(comprador);
        validarCampoCiudad(ciudad);
        validarCampoDestino(destino);
        validarCampoPrecio(precio);
        this.valorFlete(ciudad,destino);
        this.valorDescuento(fecha, precio);
        this.valorTotal(precio,flete,descuento);

        this.id = id;
        this.fecha = LocalDate.now();
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.precio= precio;



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

        private void validarCampoPrecio(int precio){
        if (precio == 0) {
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }


    private int valorTotal(int precio, int flete, int descuento) {
      return this.total=Math.round(precio+flete-descuento);
    }

    private int valorDescuento(LocalDate fecha, int precio) {

        if (fecha==LocalDate.now()){
            return this.descuento= (int) (precio*0.05);
            }
        else{


            return this.descuento=0;}


    }

    private int valorFlete(String ciudad, String destino) {
        if (ciudad.equals(destino) ){
        return this.flete=0;}
        else{
            return this.flete=30000;
        }
    }
}



