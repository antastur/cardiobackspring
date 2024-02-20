package com.proyectocardio.proyectocardio.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyectocardio.proyectocardio.models.Equipo;
import java.util.List;

import java.time.LocalDate;




@Repository
public interface EquipoRepository extends  JpaRepository<Equipo,Long> {

   

   List<Equipo> findByAsignado(Boolean asignado);
   List<Equipo> findByCondicionUsado(Boolean asignado);
   List<Equipo> findByRefCabina(String refCabina);
   List<Equipo> findByFechaCaducidadBefore(LocalDate fechaCaducidad);

   //@Query( value="select e from Equipo e where e.fechaCaducidad < ?1")
   //public List<Equipo> findByFechaCaducidad(LocalDate localDate);
   
    
}
