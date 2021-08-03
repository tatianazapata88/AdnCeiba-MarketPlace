package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarCompraTest {

    @Test
    public void validarActualizacionCompraTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conId(1L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        servicioActualizarCompra.ejecutar(compra);
        String ciudad = "medellin";
        // act - assert
        Assert.assertEquals(compra.getCiudadoOrigenUbicacionScotter(), ciudad);
    }
}
