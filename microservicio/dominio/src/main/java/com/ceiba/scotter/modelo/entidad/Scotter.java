package com.ceiba.scotter.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;

@Getter
public class Scotter {

    public enum Estado {DISPONIBLE, RESERVADA}  ;

    private static final String CAMPO_MARCA_ES_OBLIGATORIO = "El campo marca es obligatorio no puede ir vacio";
    private static final String CAMPO_MODELO_ES_OBLIGATORIO = "El campo modelo es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad es obligatorio no puede ir vacio";
   // private static final String CAMPO_VENDEDOR_ES_OBLIGATORIO = "El campo vendedor es obligatorio no puede ir vacio";
    private static final String CAMPO_FOTO_ES_OBLIGATORIO = "El campo foto es obligatorio no puede ir vacio";

    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private String ciudad;
    public Persona vendedor;
    //private String estado;
    private String foto;
    public Estado estado;

    public Scotter(Long id, String marca, String modelo, double precio, String ciudad, Persona vendedor, String foto) {
        validarCampoMarcaVacio(marca);
        validarCampoModeloVacio(modelo);
        validarCampoPrecioVacio(precio);
        validarCampoCiudadVacio(ciudad);
        //validarCampoVendedorVacio(vendedor);
        validarCampoFotoVacio(foto);

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.estado = Estado.DISPONIBLE;
        this.foto = foto;
    }

     void validarCampoMarcaVacio(String marca) {
        if (marca == null || marca.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_MARCA_ES_OBLIGATORIO);
        }
    }

     void validarCampoModeloVacio(String modelo) {
        if (modelo == null || modelo.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_MODELO_ES_OBLIGATORIO);
        }
    }

     void validarCampoPrecioVacio(double precio) {
        if (precio == 0) {
            throw new ExcepcionValorObligatorio(CAMPO_PRECIO_ES_OBLIGATORIO);
        }
    }

     void validarCampoCiudadVacio(String ciudad) {
        if (ciudad == null || ciudad.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_CIUDAD_ES_OBLIGATORIO);
        }
    }

    /* void validarCampoVendedorVacio(Long vendedor) {
        if (vendedor == null) {
            throw new ExcepcionValorObligatorio(CAMPO_VENDEDOR_ES_OBLIGATORIO);
        }
    }*/

     void validarCampoFotoVacio(String foto) {
        if (foto == null || foto.trim().length() <= 0) {
            throw new ExcepcionValorObligatorio(CAMPO_FOTO_ES_OBLIGATORIO);
        }
    }
}
