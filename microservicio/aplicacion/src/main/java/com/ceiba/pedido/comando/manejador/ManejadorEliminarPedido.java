package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPedido implements ManejadorComando<Long> {

    private final ServicioEliminarPedido servicioEliminarPedido;

    public ManejadorEliminarPedido(ServicioEliminarPedido servicioEliminarPedido) {
        this.servicioEliminarPedido = servicioEliminarPedido;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarPedido.ejecutar(id);
    }
}
