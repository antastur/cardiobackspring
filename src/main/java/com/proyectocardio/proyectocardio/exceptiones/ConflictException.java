package com.proyectocardio.proyectocardio.exceptiones;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción

public class ConflictException extends RuntimeException {

    private static final String DESCRIPTION= "La solicitud no se ha podido procesar debido a un conflicto en la solicitud 409";

    public ConflictException(String detail){
        super(DESCRIPTION+". "+detail);
    }
}
