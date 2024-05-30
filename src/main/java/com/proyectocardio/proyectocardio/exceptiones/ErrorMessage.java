package com.proyectocardio.proyectocardio.exceptiones;

//Clase que representa un mensaje de error que se manda al cliente ante un error de la aplicacion

public class ErrorMessage {

    // Declaración de propiedades del mensaje a mostrar
    private String exception;

    private String message;

    private String path;

    

    // Constructor
    public ErrorMessage(Exception exception, String path) {

        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;

    }

    // getters
    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    
    public void setException(String exception) {
        this.exception = exception;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "exception='" + exception + '\'' + ", message='" + message + '\'' + ", path='" + path
                + '\'' + '}';
    }

}
