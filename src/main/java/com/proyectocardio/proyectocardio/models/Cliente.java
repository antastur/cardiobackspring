package com.proyectocardio.proyectocardio.models;



import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Column(name="cif")
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
    private Set<Espacio> espacio;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Curso> curso;

  

    
    
}
