package com.ceiba.scotter.servicio.testdatabuilder;

import com.ceiba.persona.ComandoPersona;
import com.ceiba.persona.servicio.testdatabuilder.ComandoPersonaTestDataBuilder;
import com.ceiba.scotter.comando.ComandoScotter;

public class ComandoScotterTestDataBuilder {
    private Long id;
    private String marca;
    private String modelo;
    private Integer precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private String foto;

    public ComandoScotterTestDataBuilder(){
        marca = "enduro";
        modelo= "2019";
        precio = 3500000;
        ciudad = "Santa Marta";
        vendedor = 1L;
        foto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1qy1IibO2Euuk15nA50EQhfTUg5JuUUSUag&usqp=CAU";
    }

    public ComandoScotterTestDataBuilder conPrecio(Integer precio) {
        this.precio = precio;
         return this;    }

    public ComandoScotterTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;    }

    public ComandoScotterTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoScotter build() {
        return new ComandoScotter(id,marca,modelo,precio,ciudad,vendedor,foto);
    }

}
