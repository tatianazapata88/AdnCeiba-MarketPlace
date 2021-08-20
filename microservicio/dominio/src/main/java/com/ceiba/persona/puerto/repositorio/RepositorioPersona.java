package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;

public interface RepositorioPersona {

    Long crear(Persona persona);

    boolean existe(String username);

    void actualizar(Persona persona);

    boolean existePorActualizar(String username, Long id);

    void eliminar(Long id);

    boolean existePorPedido(Long id);

    Persona obtenerPersonaPorId(Long id);
}
