package com.ceiba.scotter.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidad.Persona;
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

public class ServicioCrearScotterTest {

    private static final String MARCA = "ducati";
    private static final String MODELO = "2022";
    private static final int PRECIO = 10000000;
    private static final String CIUDAD = "Cartagena";
    private static final Persona VENDEDOR = new Persona(2l, "salo", "salome agudelo", "3003680128", "salo@gmail.com");
    private static final Scotter.Estado ESTADO = Scotter.Estado.DISPONIBLE;
    private static final String FOTO = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjJsAEYpvYNqlZ6jM9SYeDJo8gUN_-RPfiLg&usqp=CAU";

    private static final String CAMPO_MARCA_ES_OBLIGATORIO = "El campo marca es obligatorio no puede ir vacio";
    private static final String CAMPO_MODELO_ES_OBLIGATORIO = "El campo modelo es obligatorio no puede ir vacio";
    private static final String CAMPO_PRECIO_ES_OBLIGATORIO = "El campo precio es obligatorio no puede ir vacio";
    private static final String CAMPO_CIUDAD_ES_OBLIGATORIO = "El campo ciudad es obligatorio no puede ir vacio";
    private static final String CAMPO_FOTO_ES_OBLIGATORIO = "El campo foto es obligatorio no puede ir vacio";

    @Mock
    private RepositorioScotter repositorioScotter;

    @InjectMocks
    private ServicioCrearScotter servicioCrearScotter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

       @Test
 public void validarCampoMarcaVacioTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(null, MODELO, PRECIO, CIUDAD, VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_MARCA_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoMarcaBlancoTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(" ", MODELO, PRECIO, CIUDAD, VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_MARCA_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoModeloVacioTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, null, PRECIO, CIUDAD, VENDEDOR, ESTADO,FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_MODELO_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoModeloBlancoTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, " ", PRECIO, CIUDAD, VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_MODELO_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoPrecioCeroTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, MODELO, 0, CIUDAD, VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_PRECIO_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadVacioTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, MODELO, PRECIO, null, VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCiudadBlancoTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, MODELO, PRECIO, " ", VENDEDOR,ESTADO, FOTO);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CIUDAD_ES_OBLIGATORIO);
    }

     @Test
    public void validarCampoFotoVacioTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, MODELO, PRECIO, CIUDAD, VENDEDOR,ESTADO, null);
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_FOTO_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoFotoBlancoTest() {
        // arrange
        ScotterTestDataBuilder scotterTestDataBuilder = new ScotterTestDataBuilder(MARCA, MODELO, PRECIO, CIUDAD, VENDEDOR,ESTADO, " ");
        // act - assert
        BasePrueba.assertThrows(() -> scotterTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_FOTO_ES_OBLIGATORIO);
    }

    @Test
    public void agregarScotterTest1() {
        //arrange
        Long valorEsperado = 1L;
        Scotter scotter = new ScotterTestDataBuilder().build();
        Mockito.when(repositorioScotter.crear(scotter)).thenReturn(scotter.getId());
        ServicioCrearScotter servicioCrearScotter = new ServicioCrearScotter(repositorioScotter);
        Long valorActual = servicioCrearScotter.ejecutar(scotter);
        //act assert
        Assert.assertEquals(valorEsperado, valorActual);
     }
}
