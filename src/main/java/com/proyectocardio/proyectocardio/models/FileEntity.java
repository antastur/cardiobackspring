package com.proyectocardio.proyectocardio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



// @Entity
// @Table(name = "files")
// @Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileEntity {
    // @Id
    // @GeneratedValue
    // private long id;

    private String name;

    private String url;

    private String message;

    public FileEntity(String message){
        this.message= message;
    }

    public FileEntity(String name,String url){
        this.name=name;
        this.url=url;
    }
}
