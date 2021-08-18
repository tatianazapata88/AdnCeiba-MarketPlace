package com.ceiba.scotter.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;

public class ComandoScotterTestDataBuilder {
    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private String ciudad;
    private Long id_vendedor;
    private Scotter.Estado estado;
    private String foto;

    public ComandoScotterTestDataBuilder() {
        marca = "enduro";
        modelo = "2019";
        precio = 3500000.0;
        ciudad = "Santa Marta";
        id_vendedor = 1L;
        estado = Scotter.Estado.DISPONIBLE;
        foto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1qy1IibO2Euuk15nA50EQhfTUg5JuUUSUag&usqp=CAU";
    }

    public ComandoScotterTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ComandoScotterTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ComandoScotterTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoScotter build() {
        return new ComandoScotter(id, marca, modelo, precio, ciudad, id_vendedor, foto);
    }

}
