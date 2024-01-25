package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Equipo;

@Service
public interface IEquipoService {

    public List<Equipo> getEquipos();
    public Equipo creaEquipo(Equipo equipo);
    public Equipo cambiarEquipo(Long id,Equipo equipo);
    public Boolean borrarEquipo(Long id);
    public Equipo  getEquipo(Long id);
}
