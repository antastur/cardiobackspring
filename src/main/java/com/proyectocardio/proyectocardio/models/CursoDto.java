package com.proyectocardio.proyectocardio.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoDto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ingresa Nombre del curso")
    @Column(name = "nombre", unique = true)
    private String nombre;

}
