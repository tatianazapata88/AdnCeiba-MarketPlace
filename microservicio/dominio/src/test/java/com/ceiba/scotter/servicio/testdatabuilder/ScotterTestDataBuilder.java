package com.ceiba.scotter.servicio.testdatabuilder;

import com.ceiba.scotter.modelo.entidad.Scotter;


import java.time.LocalDateTime;

public class ScotterTestDataBuilder {
    private Long id;
    private String marca;
    private String modelo;
    private Integer precio;
    private String ciudad;
    private Long vendedor;
    private String estado;
    private  String foto;

    public ScotterTestDataBuilder() {
        id= 1L;
        marca = "toyota";
        modelo = "2022";
        precio = 6000000;
        ciudad = "Cali";
        vendedor = 2L;
        estado = "disponible";
        foto = "https://www.google.com/search?q=foto+hd+scooter&rlz=1C1UUXU_esCO947CO947&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjcyNSkxPTxAhXkRjABHb2SBecQ_AUoAXoECAEQAw&biw=1600&bih=757";

    }

    public ScotterTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Scotter build() {
        return new Scotter(id,marca, modelo,precio,ciudad,vendedor,estado,foto);
    }
}
