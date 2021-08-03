package com.ceiba.scotter.servicio;

import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import com.ceiba.scotter.servicio.testdatabuilder.ScotterTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarScotterTest {

    @Test
    public void validarActualizarScotterTest() {
        // arrange
        Long id = 1L;
        Scotter scotter = new ScotterTestDataBuilder().conId(id).build();
        RepositorioScotter repositorioScotter = Mockito.mock(RepositorioScotter.class);
        ServicioActualizarScotter servicioActualizarScotter = new ServicioActualizarScotter(repositorioScotter);
        servicioActualizarScotter.ejecutar(scotter);
        String ciudad = "Cali";
        // act - assert
        Assert.assertEquals(scotter.getCiudad(), ciudad);
    }
}
