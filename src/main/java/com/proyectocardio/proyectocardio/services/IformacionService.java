package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.FormacionDto;

@Service
public interface IformacionService {

    //Contrato de los métodos que ha de gestionar el servicio de una formación
  // public List<FormacionDto> getFormacion();
    //public FormacionDto creaFormacion(Formacion formacion);
   // public FormacionDto cambiarFormacion(Long id,Formacion formacion);
    public void borrarFormacion(Long id);
    //public FormacionDto getFormacion(Long id); 
    public List<Formacion> getFormacionesByCurso(Long id);
}
