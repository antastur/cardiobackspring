package com.proyectocardio.proyectocardio.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo extends Lugar {

    @Id
    @Column(name="id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

 
    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    @NotNull(message="Introducir matricula")
    @Column(name="matricula")
    private String matricula;


    @Column(name="telefono")
    private String telefono;

   


}
