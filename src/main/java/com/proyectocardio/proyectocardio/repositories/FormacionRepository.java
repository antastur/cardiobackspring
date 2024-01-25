package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Formacion;

@Repository
public interface FormacionRepository extends  JpaRepository<Formacion,Long> {

}
