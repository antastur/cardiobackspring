package com.proyectocardio.proyectocardio.exceptiones;

import org.apache.coyote.BadRequestException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

//Clase manejadora a nivel global de aplicación de las excepciones en la api

//Anotacion que dice a la aplicacion que la clase es aplicable a todos los controladores
//@RestControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
/* 

       //controla los errores de los campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlderMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          WebRequest webRequest) {
        Map<String, String> mapErrors = new HashMap<>();
       
      exception.getBindingResult().getAllErrors().forEach((error) -> {
                    String clave = ((FieldError) error).getField();
                    String valor = error.getDefaultMessage();
                    mapErrors.put(clave, valor);
                }
        );
        ApiResponse apiResponse = new ApiResponse(mapErrors.toString(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    //controla los errores not found 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    //controla los errores globales de los path en 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handlerNoHandlerFoundException(NoHandlerFoundException  exception,
                                                                        WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    //controla los errores de logica o de los catch en general 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handlerBadRequestException(BadRequestException exception,
                                                                        WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }




 //controla los errores de varios tipos y globalizrlo con un error 500
 //   @ExceptionHandler(Exception.class)
   // public ResponseEntity<ApiResponse> handlerException(Exception exception,
   //                                                               WebRequest webRequest) {
     //   ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
    //    return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
 //   }

                                                                
                                                              
    //controla los errores de varios tipos y globalizrlo con un error 500
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse> handlerHttpMethodNotSupportedExceptionHelper(HttpRequestMethodNotSupportedException exception,
                                                                  WebRequest webRequest) {
       ApiResponse apiResponse = new ApiResponse(exception.getMessage(), webRequest.getDescription(false));
       return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    } 



    */
    //Metodo que ante una solicitud y excepción  devuelve un mensaje con formato ErrorMessage con status not_found  
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception){

      return new ErrorMessage(exception, request.getRequestURI());
    }


 //Metodo que agrupa las excepciones relacionadas con un status bad_request
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            //org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
           // org.springframework.http.converter.HttpMessageNotReadableException.class,
    })
   @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception){

      return new ErrorMessage(exception, request.getRequestURI());
    }


    //Metodo que agrupa las excepciones relacionadas con un status bad_conflict
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class,
      org.springframework.dao.DuplicateKeyException.class,
      org.springframework.dao.DataIntegrityViolationException.class,
      jakarta.validation.ConstraintViolationException.class,
      jakarta.validation.ValidationException.class,
      
      
      //org.springframework.web.HttpRequestMethodNotSupportedException.class,
      //org.springframework.web.bind.MethodArgumentNotValidException.class,
     })
    @ResponseBody
    public ErrorMessage conflictRequest(HttpServletRequest request, Exception exception){

      return new ErrorMessage(exception, request.getRequestURI());
    }



    //Metodo que gestiona excepcion relacionada con un status bad_unauthorized
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnAuthorizedException.class
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
