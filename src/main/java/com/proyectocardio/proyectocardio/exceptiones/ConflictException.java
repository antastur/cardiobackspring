package com.proyectocardio.proyectocardio.exceptiones;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción
public class ConflictException extends RuntimeException {

    private static final String DESCRIPTION = "Conflicto en BD";

    public ConflictException(String detail) {

        super(DESCRIPTION + ". " + detail);
    }
}
