package com.ceiba.scotter.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.scotter.modelo.entidad.Scotter;

public class ScotterTestDataBuilder {
    private Long id;
    private String marca;
    private String modelo;
    private double precio;
    private String ciudad;
    public Persona vendedor;
    private Scotter.Estado estado;
    private String foto;

    public ScotterTestDataBuilder(String marca, String modelo, double precio, String ciudad,
                                  Persona vendedor, Scotter.Estado estado, String foto) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.ciudad = ciudad;
        this.vendedor = vendedor;
        this.estado =estado;
        this.foto = foto;
    }

    public ScotterTestDataBuilder() {
        id = 1L;
        marca = "toyota";
        modelo = "2022";
        precio = 6000000.0;
        ciudad = "Cali";
        vendedor = new Persona(1l,"salo","salome agudelo","3003680128","salo@gmail.com");
        estado = Scotter.Estado.DISPONIBLE;
        foto = "https://www.google.com/search?q=foto+hd+scooter&rlz=1C1UUXU_esCO947CO947&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjcyNSkxPTxAhXkRjABHb2SBecQ_AUoAXoECAEQAw&biw=1600&bih=757";
    }

    public ScotterTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ScotterTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ScotterTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Scotter build() {
        return new Scotter(id,marca, modelo, precio, ciudad, vendedor, foto);
    }
}
