package com.proyectocardio.proyectocardio.exceptiones;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción

public class NotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "No se encuentra ";

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
