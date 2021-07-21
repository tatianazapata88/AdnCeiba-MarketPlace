package com.ceiba.scotter.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Scotter {
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DE_LA_SCOTTER = "Se debe ingresar la marca de la scotter";
    private static final String SE_DEBE_INGRESAR_EL_MODELO_DE_LA_SCOTTER = "Se debe ingresar el modelo de la scotter";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_SCOTTER = "Se debe ingresar el precio de la scotter";
    private static final String SE_DEBE_INGRESAR_LA_CIUDAD_DE_UBICACION = "Se debe ingresar la ciudad de ubicacion de la scotter";
    private static final String SE_DEBE_INGRESAR_LA_FOTO_DE_LA_SCOTTER = "Se debe ingresar la foto de la scotter";


    private Long id;
    private String marca;
    private String modelo;
    private Integer precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private String foto;


    public Scotter(Long id, String marca, String modelo, Integer precio, String ciudad, Long vendedor, String estado, String foto) {
        validarObligatorio(marca,SE_DEBE_INGRESAR_LA_MARCA_DE_LA_SCOTTER );
        validarObligatorio(modelo, SE_DEBE_INGRESAR_EL_MODELO_DE_LA_SCOTTER);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DE_LA_SCOTTER);
        validarObligatorio(ciudad, SE_DEBE_INGRESAR_LA_CIUDAD_DE_UBICACION);
        validarObligatorio(foto, SE_DEBE_INGRESAR_LA_FOTO_DE_LA_SCOTTER);

        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.estado = "disponible";
        this.foto = foto;
    }
}
