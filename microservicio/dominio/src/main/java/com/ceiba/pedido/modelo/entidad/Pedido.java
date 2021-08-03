package com.ceiba.pedido.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import lombok.Getter;


import java.time.LocalDate;


@Getter
public class Pedido {
    private static final double DESCUENTO = 0.05;
    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;

    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
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
    private double flete;
    private double precio;
    private double descuento;
    private double total;

    public Pedido(Long id, LocalDate fecha, Long bici, Long comprador, String ciudad, String destino, double precio) {
        validarCampoFecha(fecha);
        validarCampoBici(bici);
        validarCampoComprador(comprador);
        validarCampoCiudad(ciudad);
        validarCampoDestino(destino);
        validarCampoPrecio(precio);


        this.id = id;
        this.fecha = fecha;
        this.bici = bici;
        this.comprador = comprador;
        this.ciudad = ciudad;
        this.destino = destino;
        this.flete = this.valorFlete(ciudad, destino);
        this.precio = precio;
        this.descuento = this.valorDescuento(this.fecha, precio);
        this.total = this.valorTotal(precio, this.flete, this.descuento);


    }

    private void validarCampoFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new ExcepcionValorObligatorio(CAMPO_FECHA_ES_OBLIGATORIO);
        }
    }

    private void validarCampoBici(Long bici) {
        if (bici == null) {
            throw new ExcepcionValorObligatorio(CAMPO_BICI_ES_OBLIGATORIO);
        }
    }

    private void validarCampoComprador(Long comprador) {
        if (comprador == null) {
            throw new ExcepcionValorObligatorio(CAMPO_COMPRADOR_ES_OBLIGATORIO);
        }
    }

    private void validarCampoCiudad(String ciudad) {
        if (ciudad == null || ciudad.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_ES_OBLIGATORIO);
        }
    }

    private void validarCampoDestino(String destino) {
        if (destino == null || destino.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_DESTINO_ES_OBLIGATORIO);
        }
    }

    private void validarCampoPrecio(double precio) {
        if (precio == 0.0) {
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }


    private double valorTotal(double precio, double flete, double descuento) {
        double total = precio + flete - descuento;
        return this.total = total;
    }



    private double valorDescuento(LocalDate fecha,double precio) {
        int diferenciaFechas = fecha.compareTo(LocalDate.now());
        if (diferenciaFechas == 0) {
            double calcularDescuento = Math.round(precio * DESCUENTO);
            return this.descuento = calcularDescuento;
        } else {
            return this.descuento = SIN_DESCUENTO;
        }

    }
    private double valorFlete(String ciudad, String destino) {
        if (ciudad.equals(destino)) {
            return this.flete = VALOR_FLETE_MISMA_CIUDAD;
        } else {
            return this.flete = VALOR_FLETE_DIFERENTE_CIUDAD;
        }
    }
}



