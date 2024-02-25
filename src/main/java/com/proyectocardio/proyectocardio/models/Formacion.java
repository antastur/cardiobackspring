package com.proyectocardio.proyectocardio.models;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Formacion {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tipo")
    private String tipo;

    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(iso=ISO.DATE)
   // @Future
    @NotNull(message="Ingresa día de la formación")
    @Column(name="dateFormacion")
    private LocalDate dateFormacion;

    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(iso=ISO.DATE)
    @NotNull(message="Ingresa fecha recuerdo")
    //@Future
    @Column(name="recuerdo")
    private LocalDate recuerdo;

    @Column(name="senaletica")
    private boolean senaletica;

    @Column(name="numAsistentes")
    private int numAsistentes;

    @Column(name="estado")
    private boolean estado;

    @Column(name="impartidor")
    private String impartidor;
    
    @OneToMany(mappedBy="formacion")
    @JsonManagedReference(value="formacion-diploma")
    private Set<Diploma> diplomas;
    
    @OneToMany(mappedBy = "formacion")
    @JsonManagedReference(value="formacion-alumno")
    private Set<Alumno> alumnos;

    @ManyToOne
    @JsonBackReference(value="curso-formacion")
    @JoinColumn(name = "FK_CURSO", updatable = true, nullable = true)
    private Curso curso;


    
}

