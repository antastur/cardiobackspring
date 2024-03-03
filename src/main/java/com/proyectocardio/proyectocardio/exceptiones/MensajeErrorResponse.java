package com.proyectocardio.proyectocardio.exceptiones;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MensajeErrorResponse {

    private String mensaje;

}
