package com.ceiba.configuracion;

import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.scotter.puerto.repositorio.RepositorioScotter;
import com.ceiba.scotter.servicio.ServicioActualizarScotter;
import com.ceiba.scotter.servicio.ServicioCrearScotter;
import com.ceiba.scotter.servicio.ServicioEliminarScotter;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
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
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido) {
        return new ServicioCrearPedido(repositorioPedido);
    }

    @Bean
    public ServicioActualizarPedido servicioActualizarPedido(RepositorioPedido repositorioPedido) {
        return new ServicioActualizarPedido(repositorioPedido);
    }
    @Bean
    public ServicioEliminarPedido servicioEliminarPedido(RepositorioPedido repositorioPedido) {
        return new ServicioEliminarPedido(repositorioPedido);
    }

}
