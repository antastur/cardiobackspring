package com.proyectocardio.proyectocardio.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Equipo;

@Service
public interface IEquipoService {

    public List<Equipo> getEquipos();
    public Equipo creaEquipo(Equipo equipo);
    public Equipo cambiarEquipo(Long id,Equipo equipo);
    public Boolean borrarEquipo(Long id);
    public Equipo  getEquipo(Long id);
    public List<Equipo> getEquiposNoAsignados(Boolean asignado);

    public List<Equipo> findByAsignado(Boolean asignado);
    public List<Equipo> findByRefCabina(Boolean asignado);
    public List<Equipo> findByCondicionUsado(Boolean asignado);
    public List<Equipo> findByFechaCaducidadBefore(LocalDate fechaCaducidad);
     //List<Equipo> findByFechaCaducidad(LocalDate localDate);


}