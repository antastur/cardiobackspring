package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Cliente;

@Repository
public interface ClienteRepository extends  JpaRepository<Cliente,Long> {

    boolean existsClienteById(Long id);
}
