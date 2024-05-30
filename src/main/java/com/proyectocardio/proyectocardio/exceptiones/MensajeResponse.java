package com.proyectocardio.proyectocardio.exceptiones;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

//Clase que traslada mensaje desde back a front
@Data
@ToString
@Builder
public class MensajeResponse implements Serializable {

    private String mensaje;
    private Object object;

}