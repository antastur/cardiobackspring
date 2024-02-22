package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Formacion;

import java.util.List;


@Repository
public interface AlumnoRepository extends  JpaRepository<Alumno,Long> {
  List<Alumno> findByFormacion(Formacion formacion);
}
