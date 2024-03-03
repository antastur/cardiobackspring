package com.proyectocardio.proyectocardio.models;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.core.annotation.Order;

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

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
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
public class Espacio  {


    
    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Ingresa la direccion")
    @Column(name="direccion", unique = true)
    private String direccion;

    @Column(name="horario")
    private String horario;

    @Column(name="numTelef")
    private String numTelef;

    @Email
    @Column(name="email")
    private String email;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name="fechRegDga")
    private LocalDate fechRegDga;

    @ManyToOne
    @JsonBackReference(value="cliente-espacio")
    @JoinColumn(name = "FK_CLIENTE", updatable = true, nullable = true)
    private Cliente cliente;

    @OneToMany(mappedBy = "espacio")
    @JsonManagedReference (value="espacio-lugar")
    private Set<Lugar> lugares;
    
 













}
