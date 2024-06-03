package com.proyectocardio.proyectocardio.exceptiones;

public class FileUploadException extends RuntimeException {
    private static final String DESCRIPTION = "El archivo excede el tamaño permitido";

    public FileUploadException(String detail) {

        super(DESCRIPTION + ". " + detail);
    }
}
