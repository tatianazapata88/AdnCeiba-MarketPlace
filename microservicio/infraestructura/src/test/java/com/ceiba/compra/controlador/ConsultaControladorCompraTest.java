package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorCompra.class)
public class ConsultaControladorCompraTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarCompraTest() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/compras")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    public void buscarCompraIdTest() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(get("/compras/id/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("ciudadDestinoEnvioScotter", Is.is("Medellin")));
    }
}
