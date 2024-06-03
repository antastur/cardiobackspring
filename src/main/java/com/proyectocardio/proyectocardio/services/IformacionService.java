package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.FormacionDto;

@Service
public interface IformacionService {

    //Contrato de los métodos que ha de gestionar el servicio de una formación
    public List<FormacionDto> getFormacion();
    public Formacion creaFormacion(Formacion formacion);
    public Formacion cambiarFormacion(Long id,Formacion formacion);
    public void borrarFormacion(Formacion formacion);
    public Optional<Formacion>  getFormacion(Long id);
    public List<Formacion> findByFormacion(Formacion formacion);
}
