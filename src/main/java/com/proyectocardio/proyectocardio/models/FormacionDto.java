package com.proyectocardio.proyectocardio.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class FormacionDto {

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
}
