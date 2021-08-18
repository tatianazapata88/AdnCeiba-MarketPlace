package com.ceiba.compra.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.compra.comando.ComandoCompra;
import com.ceiba.compra.comando.fabrica.FabricaCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCompra implements ManejadorComandoRespuesta<ComandoCompra, ComandoRespuesta<Long>> {

    private final FabricaCompra fabricaPedido;
    private final ServicioCrearCompra servicioCrearCompra;
    private final DaoCompra daoCompra;

    public ManejadorCrearCompra(FabricaCompra fabricaPedido, ServicioCrearCompra servicioCrearCompra, DaoCompra daoCompra) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearCompra = servicioCrearCompra;
        this.daoCompra = daoCompra;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoCompra comandoCompra) {
        Compra compra = this.fabricaPedido.crear(comandoCompra);
        return new ComandoRespuesta<>(this.servicioCrearCompra.ejecutar(compra));
    }
}
