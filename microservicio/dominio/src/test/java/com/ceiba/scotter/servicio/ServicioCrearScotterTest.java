package com.ceiba.scotter.servicio;

import com.ceiba.scotter.servicio.testdatabuilder.ScotterTestDataBuilder;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioCrearScotterTest {

    @Mock
    private RepositorioScotter repositorioScotter;

    @InjectMocks
    private ServicioCrearScotter servicioCrearScotter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void agregarScotterTest1() {
        //arrange
        Long valorEsperado =1L;
        Scotter scotter = new ScotterTestDataBuilder().build();

        Mockito.when(repositorioScotter.crear(scotter)).thenReturn(scotter.getId());

        ServicioCrearScotter servicioCrearScotter = new ServicioCrearScotter(repositorioScotter);

        Long valorActual =servicioCrearScotter.ejecutar(scotter);
        //act assert
        Assert.assertEquals(valorEsperado, valorActual);
        ;
    }


}
