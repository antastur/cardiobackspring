package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Espacio;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio,Long>{

}
