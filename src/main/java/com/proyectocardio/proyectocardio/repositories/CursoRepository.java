package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Curso;

@Repository
public interface CursoRepository extends  JpaRepository<Curso,Long> {

}
