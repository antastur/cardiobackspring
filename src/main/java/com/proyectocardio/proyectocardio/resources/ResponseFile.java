package com.proyectocardio.proyectocardio.resources;

import lombok.Builder;
import lombok.Data;





//Clase para mandar y recibir archivos
@Data
@Builder
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private String size;
}
