package com.proyectocardio.proyectocardio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Lugar;

@Repository
public interface LugarRepository extends JpaRepository<Lugar,Long>{
    
}
