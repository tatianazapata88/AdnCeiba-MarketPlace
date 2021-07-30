package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.scotter.comando.ComandoScotter;
import com.ceiba.scotter.modelo.entidad.Scotter;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

        public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getBici(),
                comandoPedido.getComprador(),
                comandoPedido.getCiudad(),
                comandoPedido.getDestino(),
                comandoPedido.getPrecio()





        );

    }
}
