package com.proyectocardio.proyectocardio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectocardio.proyectocardio.models.Equipo;
import java.util.List;
import java.time.LocalDate;



//Declaracon de repositorio de Equipo
@Repository
public interface EquipoRepository extends  JpaRepository<Equipo,Long> {

   
   //Metodos añadidos a los heredados de JpaRepository
   List<Equipo> findByAsignado(Boolean asignado);
   List<Equipo> findByCondicionUsado(Boolean asignado);
   List<Equipo> findByRefCabina(String refCabina);
   List<Equipo> findByFechaCaducidadBefore(LocalDate fechaCaducidad);
 
    
}
