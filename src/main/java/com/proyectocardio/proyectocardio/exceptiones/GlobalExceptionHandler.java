package com.proyectocardio.proyectocardio.exceptiones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

/* 400 Bad Request
 * 401 Unauthorized
 * 404 Not Found
 * 405 Method Not Allowed
 * 409 Conflict
 * 401 Unauthorized
 * 500 Internal server
*/

//Clase manejadora a nivel global de aplicación de las excepciones en la api

//Anotacion que dice a la aplicacion que la clase es aplicable a todos los controladores
//@RestControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //Metodo que ante una solicitud y excepción  devuelve un mensaje con formato ErrorMessage con status not_found  
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){

      return new ErrorMessage(exception, request.getRequestURI());
    }


    //Metodo que agrupa las excepciones relacionadas con un status bad_conflict
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class,
    org.springframework.dao.DataIntegrityViolationException.class,
    jakarta.validation.ConstraintViolationException.class,
    })
    @ResponseBody
    public ErrorMessage conflictRequest(Exception exception, HttpServletRequest request ){

      return new ErrorMessage(exception, request.getRequestURI());
    }




 //Metodo que agrupa las excepciones relacionadas con un status bad_request
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ BadRequestException.class,
            jakarta.validation.ValidationException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
           // org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
           // org.springframework.http.converter.HttpMessageNotReadableException.class,
           // org.springframework.web.HttpRequestMethodNotSupportedException.class,
    })
   @ResponseBody
    public ErrorMessage badRequest(Exception exception, HttpServletRequest request ){

      return new ErrorMessage(exception, request.getRequestURI());
    }




    //Metodo que gestiona excepcion relacionada con un status bad_unauthorized
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnAuthorizedException.class,
                     // org.springframework.security.access.AccessDeniedException.clas 
    })
    public void unauthorizedRequest(){
       //
    }



     //Metodo que gestiona excepciones no capturadas por los anteriores métodos
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorMessage fatalErrorUnExpectedRequest(HttpServletRequest request, Exception exception){

      return new ErrorMessage(exception, request.getRequestURI());
    }




}
