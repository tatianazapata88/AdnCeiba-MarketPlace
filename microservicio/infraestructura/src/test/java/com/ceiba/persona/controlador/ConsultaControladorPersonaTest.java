package com.ceiba.persona.controlador;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.ceiba.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorPersona.class)
public class ConsultaControladorPersonaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarTest() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/personas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username", is("taty")));
    }

    @Test
    public void listarIdTest() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(get("/personas/id/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username", is("taty")));
    }

    @Test
    public void listarUsernameTest() throws Exception {
        // arrange
        String username = "taty";
        // act - assert
        mocMvc.perform(get("/personas/username/{username}", username)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username", is("taty")));
    }
}
