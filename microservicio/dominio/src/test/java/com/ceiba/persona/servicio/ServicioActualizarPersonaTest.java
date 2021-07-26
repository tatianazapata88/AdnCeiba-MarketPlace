package com.ceiba.persona.servicio;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioActualizarPersonaTest {

    private static final String USERNAME_YA_REGISTRADO_EN_EL_SISTEMA = "No se puede registrar la persona por que ya existe el username";
    @Test
    public void validarPersonaExistenciaPreviaTest() {
        // arrange
        String username = "taty";
        Persona persona = new PersonaTestDataBuilder().conUsername(username).build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existePorActualizar(Mockito.any(),Mockito.any())).thenReturn(true);
        ServicioActualizarPersona servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPersona.ejecutar(persona), ExcepcionDuplicidad.class,USERNAME_YA_REGISTRADO_EN_EL_SISTEMA);
    }

    @Test
    public void validarPersonaTest() {
        // arrange
        String username = "taty";
        Persona persona = new PersonaTestDataBuilder().conUsername(username).build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        ServicioActualizarPersona servicioActualizarPersona = new ServicioActualizarPersona(repositorioPersona);
        servicioActualizarPersona.ejecutar(persona);
        String celular = "3135151617";
        // act - assert
        Assert.assertEquals(persona.getCelular(), celular);
    }
}
