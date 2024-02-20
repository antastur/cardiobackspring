package com.proyectocardio.proyectocardio.exceptiones;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción
public class UnAuthorizedException extends RuntimeException{

    private static final String DESCRIPTION= "Solicitud no autorizada 401";

    public UnAuthorizedException(String detail){
        super(DESCRIPTION+". "+detail);
    }
}
