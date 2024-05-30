package com.proyectocardio.proyectocardio.exceptiones;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción
public class BadRequestException extends RuntimeException {

    private static final String DESCRIPTION = "Error en la solicitud falta campo";

    public BadRequestException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
