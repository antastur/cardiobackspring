package com.proyectocardio.proyectocardio.models;


import java.time.LocalDate;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @Column(name="dni")
    private String dni;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(iso=ISO.DATE)
    @Nonnull
    @Column(name="fecha")
    private LocalDate fecha;

    @Column(name="impartidor")
    private String impartidor;

    @ManyToOne
    @JoinColumn(name = "FK_FORMACION", updatable = true, nullable =true)
    private Formacion formacion;

    @OneToOne
    private Alumno alumno;
}
