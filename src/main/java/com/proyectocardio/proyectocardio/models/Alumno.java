package com.proyectocardio.proyectocardio.models;



import org.hibernate.validator.constraints.Length;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


//Se establece como entidad y se crean getters, setters y constructores con Lombock
@Entity
@Data

public class Alumno {
    
    //Se establece clave primaria para que se genere automaticamente
    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotNull(message = "Has de ingresar DNI")
    @Column(name="dniAlumno",unique = true)
    private String dniAlumno;

    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidos")
    private String apellidos;
   
    @ManyToOne
    @JsonBackReference(value="formacion-alumno")
    @JoinColumn(name = "FK_FORMACION", updatable = true, nullable = true)
    private Formacion formacion;

    @ManyToOne
    @JsonBackReference(value="cliente-alumno")
    @JoinColumn(name = "FK_CLIENTE", updatable = true, nullable = true)
    private Cliente cliente;

    @OneToOne
    private Diploma diploma;
}
