package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Equipo;


@Repository
public interface EquipoRepository extends  JpaRepository<Equipo,Long> {

}
