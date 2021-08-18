package com.ceiba.scotter.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.persona.controlador.ComandoControladorPersona;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import com.ceiba.scotter.servicio.testdatabuilder.ComandoScotterTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPersona.class)
public class ComandoControladorScotterTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crearScotterTest() throws Exception {
        // arrange
        ComandoScotter scotter = new ComandoScotterTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/scotters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(scotter)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

     @Test
    public void actualizarScotterTest() throws Exception {
        // arrange
        Long id = 1L;
        ComandoScotter scotter = new ComandoScotterTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/scotters/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(scotter)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminarScotterTest() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/scotters/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
