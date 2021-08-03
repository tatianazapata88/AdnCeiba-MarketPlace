package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarCompraTest {
    @Test
    public void validarEliminarCompraTest() {
        // arrange
        Compra compra = new CompraTestDataBuilder().conId(2L).build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
        Long id = 2L;
        servicioEliminarCompra.ejecutar(id);
        // act - assert
        Assert.assertEquals(compra.getId(), id);
    }
}
