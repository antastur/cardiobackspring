package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Formacion;

@Service
public interface IformacionService {

    public List<Formacion> getFormaciones();
    public Formacion creaFormacion(Formacion formacion);
    public Formacion cambiarFormacion(Long id,Formacion formacion);
    public Boolean borrarFormacion(Long id);
    public Formacion getFormacion(Long id);
}
