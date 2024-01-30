package com.proyectocardio.proyectocardio.models;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    
    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dniAlumno")
    private String dniAlumno;

    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidos")
    private String apellidos;
   
    @ManyToOne
    @JsonBackReference(value="formacion-alumno")
    @JoinColumn(name = "FK_FORMACION", updatable = true, nullable = true)
    private Formacion formacion;

    @OneToOne
    private Diploma diploma;
}
