package com.ceiba.scotter.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionRelacionado;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import com.ceiba.scotter.servicio.testdatabuilder.ScotterTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarScotterTest {
    private static final String SCOTTER_TIENE_REGISTRO_EN_UN_PEDIDO = "No se puede eliminar la scotter por que existe un registro con pedido";

    @Test
    public void validarScotterEliminarTest() {
        // arrange
        Long id = 1L;
        Scotter scotter = new ScotterTestDataBuilder().conId(id).build();
        RepositorioScotter repositorioScotter = Mockito.mock(RepositorioScotter.class);
        ServicioEliminarScotter servicioEliminarScotter = new ServicioEliminarScotter(repositorioScotter);
       // Long id = 1L;
        servicioEliminarScotter.ejecutar(id);
        // act - assert
        Assert.assertEquals(scotter.getId(), id);
    }

    @Test
    public void validarScotterRelacionadaPreviaTest() {
        // arrange
        RepositorioScotter repositorioScotter = Mockito.mock(RepositorioScotter.class);
        Mockito.when(repositorioScotter.existePorPedido(Mockito.any())).thenReturn(true);
        ServicioEliminarScotter servicioEliminarScotter = new ServicioEliminarScotter(repositorioScotter);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarScotter.ejecutar(1l), ExcepcionRelacionado.class,SCOTTER_TIENE_REGISTRO_EN_UN_PEDIDO);
    }
}
