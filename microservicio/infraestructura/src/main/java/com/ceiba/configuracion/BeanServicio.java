package com.ceiba.configuracion;

import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import com.ceiba.persona.servicio.ServicioActualizarPersona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import com.ceiba.persona.servicio.ServicioEliminarPersona;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import com.ceiba.scotter.servicio.ServicioActualizarScotter;
import com.ceiba.scotter.servicio.ServicioCrearScotter;
import com.ceiba.scotter.servicio.ServicioEliminarScotter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPersona servicioCrearPersona(RepositorioPersona repositorioPersona) {
        return new ServicioCrearPersona(repositorioPersona);
    }

    @Bean
    public ServicioEliminarPersona servicioEliminarPersona(RepositorioPersona repositorioPersona) {
        return new ServicioEliminarPersona(repositorioPersona);
    }

    @Bean
    public ServicioActualizarPersona servicioActualizarPersona(RepositorioPersona repositorioPersona) {
        return new ServicioActualizarPersona(repositorioPersona);
    }

    @Bean
    public ServicioCrearScotter servicioCrearScotter(RepositorioScotter repositorioScotter) {
        return new ServicioCrearScotter(repositorioScotter);
    }

    @Bean
    public ServicioActualizarScotter servicioActualizarScotter(RepositorioScotter repositorioScotter) {
        return new ServicioActualizarScotter(repositorioScotter);
    }

    @Bean
    public ServicioEliminarScotter servicioEliminarScotter(RepositorioScotter repositorioScotter) {
        return new ServicioEliminarScotter(repositorioScotter);
    }

    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra) {
        return new ServicioCrearCompra(repositorioCompra);
    }

    @Bean
    public ServicioEliminarCompra servicioEliminarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioEliminarCompra(repositorioCompra);
    }
}
