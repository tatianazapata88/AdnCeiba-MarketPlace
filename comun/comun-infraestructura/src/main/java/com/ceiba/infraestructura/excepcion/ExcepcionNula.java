package com.ceiba.infraestructura.excepcion;

public class ExcepcionNula extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNula(String message, Exception e) {
        super(message);
    }
}