package com.proyectocardio.proyectocardio.models;




import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Cliente {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="Ingresa CIF")
    @Column(name="cif", unique=true)
    private String cif;

    @Column(name="nombEmp")
    private String nombEmp;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="dni")
    private String dni;

    @Column(name="direccionFiscal")
    private String direccionFiscal;

    @Column(name="comercial")
    private String comercial;

    
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference(value="cliente-espacio")
    private Set<Espacio> espacio;
    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference(value="cliente-curso")
    private Set<Curso> curso;

  

    
    
}
