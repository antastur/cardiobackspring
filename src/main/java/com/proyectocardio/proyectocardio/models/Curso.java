package com.proyectocardio.proyectocardio.models;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Curso {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Ingresa Nombre del curso")
    @Column(name="nombre", unique=true)
    private String nombre;
    
    @OneToMany(mappedBy = "curso")
    @JsonBackReference(value="curso-formacion")
    private List<Formacion> formaciones;

    @ManyToOne
    @JsonBackReference(value="cliente-curso")
    @JoinColumn(name = "FK_CLIENTE", updatable = true, nullable = true)
    private Cliente cliente;

    

}
