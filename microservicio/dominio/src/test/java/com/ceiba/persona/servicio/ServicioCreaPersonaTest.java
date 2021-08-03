package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCreaPersonaTest {
    private static final String USERNAME = "salo611";
    private static final String NOMBRE = "Salome Agudelo";
    private static final String CELULAR = "3002162014";
    private static final String EMAIL = "salo@gmail.com";
    private static final String CAMPO_USERNAME_ES_OBLIGATORIO = "El campo username obligatorio no puede ir vacio";
    private static final String CAMPO_NOMBRE_ES_OBLIGATORIO = "El campo nombre es obligatorio no puede ir vacio";
    private static final String CAMPO_CELULAR_ES_OBLIGATORIO = "El campo celular es obligatorio no puede ir vacio";
    private static final String CAMPO_EMAIL_ES_OBLIGATORIO = "El campo email es obligatorio no puede ir vacio";
    private static final String USERNAME_YA_REGISTRADO_EN_EL_SISTEMA = "No se puede registrar la persona por que ya existe el username";

    @Test
    public void validarCampoUsernameVacioTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(null, NOMBRE, CELULAR, EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_USERNAME_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoUsernameBlancoTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(" ", NOMBRE, CELULAR, EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_USERNAME_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoNombreVacioTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, null, CELULAR, EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_NOMBRE_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoNombreBlancoTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, " ", CELULAR, EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_NOMBRE_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCelularVacioTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, NOMBRE, null, EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CELULAR_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoCelularBlancoTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, NOMBRE, " ", EMAIL);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_CELULAR_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoEmailVacioTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, NOMBRE, CELULAR, null);
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_EMAIL_ES_OBLIGATORIO);
    }

    @Test
    public void validarCampoEmailBlancoTest() {
        // arrange
        PersonaTestDataBuilder PersonaTestDataBuilder = new PersonaTestDataBuilder(USERNAME, NOMBRE, CELULAR, " ");
        // act - assert
        BasePrueba.assertThrows(() -> PersonaTestDataBuilder.build(), ExcepcionValorObligatorio.class, CAMPO_EMAIL_ES_OBLIGATORIO);
    }

    @Test
    public void validarPersonaExistenciaPreviaTest() {
        // arrange
        String username = "salo";
        Persona persona = new PersonaTestDataBuilder().conUsername(username).build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.any())).thenReturn(true);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPersona.ejecutar(persona), ExcepcionDuplicidad.class, USERNAME_YA_REGISTRADO_EN_EL_SISTEMA);
    }

    @Test
    public void validarPersonaTest() {
        // arrange
        Persona persona = new PersonaTestDataBuilder().build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existe(Mockito.any())).thenReturn(false);
        ServicioCrearPersona servicioCrearPersona = new ServicioCrearPersona(repositorioPersona);
        String username = "taty";
        String nombre = "Luz Tatiana Zapata";
        String celular = "3135151617";
        String email = "tatianazz3@hotmail.com";
        servicioCrearPersona.ejecutar(persona);
        // act - assert
        Assert.assertEquals(persona.getUsername(), username);
        Assert.assertEquals(persona.getNombre(), nombre);
        Assert.assertEquals(persona.getCelular(), celular);
        Assert.assertEquals(persona.getEmail(), email);
    }
}
