package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

        public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getFecha(),
                comandoPedido.getBici(),
                comandoPedido.getComprador(),
                comandoPedido.getCiudad(),
                comandoPedido.getDestino(),
                comandoPedido.getPrecio()





        );

    }
}
