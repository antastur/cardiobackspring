package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectocardio.proyectocardio.models.Diploma;

@Repository
public interface DiplomaRepository extends  JpaRepository<Diploma,Long> {

}
