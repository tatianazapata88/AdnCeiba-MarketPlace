package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionRelacionado;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPersonaTest {
    private static final String PERSONA_TIENE_REGISTRO_EN_UN_PEDIDO = "No se puede eliminar la persona por que existe un registro con pedido";

    @Test
    public void validarPersonaEliminarTest() {
        // arrange

        Persona persona = new PersonaTestDataBuilder().conId(3L).build();
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        ServicioEliminarPersona servicioEliminarPersona = new ServicioEliminarPersona(repositorioPersona);
        Long id = 3L;
        servicioEliminarPersona.ejecutar(id);
        // act - assert
        Assert.assertEquals(persona.getId(), id);
    }

    @Test
    public void validarPersonaRelacionadaPreviaTest() {
        // arrange
        RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
        Mockito.when(repositorioPersona.existePorPedido(Mockito.any())).thenReturn(true);
        ServicioEliminarPersona servicioEliminarPersona = new ServicioEliminarPersona(repositorioPersona);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarPersona.ejecutar(1l), ExcepcionRelacionado.class,PERSONA_TIENE_REGISTRO_EN_UN_PEDIDO);
    }
}
