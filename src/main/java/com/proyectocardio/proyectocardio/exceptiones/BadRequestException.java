package com.proyectocardio.proyectocardio.exceptiones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Clase que describe un tipo de excepción y en su constructor obliga a incluir una descripción
//@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

   //  public BadRequestException(String mensaje) {
      //  super(mensaje);
   // }
   private static final String DESCRIPTION= "Error en la solicitud falta campo";

   public BadRequestException(String detail){
       super(DESCRIPTION+". "+detail);
   }
}
