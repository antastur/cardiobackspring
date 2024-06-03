package com.proyectocardio.proyectocardio.models;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Diploma {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    /* @NotNull(message="Ingresa DNI de alumno")
    @Column(name="dni")
    private String dni;
    
    @NotNull(message="Ingresa nombre")
    @Column(name="nombre")
    private String nombre;

    @NotNull(message="Ingresa apellidos")
    @Column(name="apellidos")
    private String apellidos; */ 

    @NotNull(message="Ingresa fecha formacion")
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(iso=ISO.DATE)
    @Column(name="fecha")
    private LocalDate fecha;

    @NotNull(message="Ingresa impartidor")
    @Column(name="impartidor")
    private String impartidor;

    @ManyToOne
    @JsonBackReference(value="formacion-diploma")
    @JoinColumn(name = "FK_FORMACION", updatable = true, nullable =true)
    private Formacion formacion;

    @OneToOne
    private Alumno alumno;
}
