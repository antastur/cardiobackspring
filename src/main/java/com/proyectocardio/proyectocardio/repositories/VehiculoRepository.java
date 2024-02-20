package com.proyectocardio.proyectocardio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Repository
public interface VehiculoRepository extends  JpaRepository<Vehiculo,Long> {


    List<Vehiculo> findAllByEspacio(Espacio espacio);
}
