package com.proyectocardio.proyectocardio.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo extends Lugar {


 
    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    @NotNull(message="Introducir matricula")
    @Column(name="matricula", unique=true)
    private String matricula;


    

   


}
