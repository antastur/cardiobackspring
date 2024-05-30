package com.proyectocardio.proyectocardio.exceptiones;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

//Clase que traslada mensaje desde back a front
@Data
@ToString
@Builder
public class MensajeErrorResponse {

    private String mensaje;

}
