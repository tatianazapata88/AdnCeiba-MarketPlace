package com.ceiba.compra.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Compra {
    private static final double VALOR_DE_DESCUENTO = 0.05;
    private static final double SIN_DESCUENTO = 0.0;
    private static final double VALOR_FLETE_MISMA_CIUDAD = 0.0;
    private static final double VALOR_FLETE_DIFERENTE_CIUDAD = 30000.0;

    private static final String CAMPO_FECHA_ES_OBLIGATORIO = "El campo fecha obligatorio no puede ir vacio";
    private static final String CAMPO_SCOTTER_ID_ES_OBLIGATORIO = "El campo scotter ID obligatorio no puede ir vacio";
    private static final String CAMPO_COMPRADOR_ES_OBLIGATORIO = "El campo id Comprador es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ORIGEN_SCOTTER_ES_OBLIGATORIO = "El campo ciudad scotter  es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO = "El campo ciudad destino  es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio  es obligatorio no puede ir vacio";

    private Long id;
    private LocalDate fecha;
    private Scotter scotter;
    private Persona comprador;
  //  private Long comprador;
    //private String ciudadoOrigenUbicacionScotter;
    private String ciudadDestinoEnvioScotter;
    private double flete;
   // private double precio;
    private double descuento;
    private double total;






    /*public Compra(Long id, LocalDate fecha, Long scotter_id, Long comprador, String ciudadoOrigenUbicacionScotter, String ciudadDestinoEnvioScotter, double precio) {
        validarCampoFecha(fecha);
        validarCampoScotterId(scotter_id);
        validarCampoComprador(comprador);
        validarCampoCiudadOrigen(ciudadoOrigenUbicacionScotter);
        validarCampoCiudadDestino(ciudadDestinoEnvioScotter);
        validarCampoPrecio(precio);

        this.id = id;
        this.fecha = fecha;
        this.scotter_id = scotter_id;
        this.comprador = comprador;
        this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.flete = this.valorFlete(ciudadoOrigenUbicacionScotter, ciudadDestinoEnvioScotter);
        this.precio = precio;
        this.descuento = this.valorDescuento(this.fecha, precio);
        this.total = this.valorTotal(precio, this.flete, this.descuento);
    }*/

        public Compra(Long id, LocalDate fecha, Scotter scotter, Persona comprador, String ciudadDestinoEnvioScotter) {
        validarCampoFecha(fecha);
       // validarCampoScotterId(scotter_id);
       // validarCampoComprador(comprador);
       // validarCampoCiudadOrigen(ciudadoOrigenUbicacionScotter);
        validarCampoCiudadDestino(ciudadDestinoEnvioScotter);
       // validarCampoPrecio(precio);

        this.id = id;
        this.fecha = fecha;
        this.scotter = scotter;
        this.comprador = comprador;
        //this.ciudadoOrigenUbicacionScotter = ciudadoOrigenUbicacionScotter;
        this.ciudadDestinoEnvioScotter = ciudadDestinoEnvioScotter;
        this.flete = this.valorFlete(scotter.getCiudad(), ciudadDestinoEnvioScotter);
        //this.precio = precio;
        this.descuento = this.valorDescuento(this.fecha, scotter.getPrecio());
        this.total = this.valorTotal(scotter.getPrecio(), this.flete, this.descuento);
    }

    private void validarCampoFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new ExcepcionValorObligatorio(CAMPO_FECHA_ES_OBLIGATORIO);
        }
    }

   /* private void validarCampoScotterId(Long scotter_id) {
        if (scotter_id == null) {
            throw new ExcepcionValorObligatorio(CAMPO_SCOTTER_ID_ES_OBLIGATORIO);
        }
    }*/

   /* private void validarCampoComprador(Long comprador) {
        if (comprador == null) {
            throw new ExcepcionValorObligatorio(CAMPO_COMPRADOR_ES_OBLIGATORIO);
        }
    }*/

  /*  private void validarCampoCiudadOrigen(String ciudadoOrigenUbicacionScotter) {
        if (ciudadoOrigenUbicacionScotter == null || ciudadoOrigenUbicacionScotter.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_ORIGEN_SCOTTER_ES_OBLIGATORIO);
        }
    }*/

    private void validarCampoCiudadDestino(String ciudadDestinoEnvioScotter) {
        if (ciudadDestinoEnvioScotter == null || ciudadDestinoEnvioScotter.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_DESTINO_SCOTTER_ES_OBLIGATORIO);
        }
    }

  /*  private void validarCampoPrecio(double precio) {
        if (precio == 0.0) {
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }*/

    private double valorTotal(double precio, double flete, double descuento) {
        double valor_total = precio + flete - descuento;
        return this.total = valor_total;
    }

    private double valorDescuento(LocalDate fecha, double precio) {
        int diferenciaFechas = fecha.compareTo(LocalDate.now());
        if (diferenciaFechas == 0) {
            double calcularDescuento = Math.round(precio * VALOR_DE_DESCUENTO);
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



