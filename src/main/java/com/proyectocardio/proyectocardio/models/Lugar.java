package com.proyectocardio.proyectocardio.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Lugar {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Introducir ubicacion")
    @Column(name="ubicacion")
    private String ubicacion;

    @Column(name="telefono")
    private String telefono;
    
    @JoinColumn(name = "FK_EQUIPO", updatable = true, nullable = true)
    @OneToOne
    private Equipo equipo;

    @ManyToOne
    @JsonBackReference(value="espacio-lugar")
    @JoinColumn(name = "FK_ESPACIO", updatable = true, nullable = false)
    private Espacio espacio;
}
