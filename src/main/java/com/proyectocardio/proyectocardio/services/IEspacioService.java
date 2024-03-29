package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Service
public interface IEspacioService {

  

   // public List<Espacio> getEspacios();
    public Espacio creaEspacio(Espacio espacio);
    public Espacio cambiarEspacio(Long id,Espacio espacio);
    public void borrarEspacio(Espacio espacio);
    public Optional<Espacio> getEspacio(Long id);
    public List<Lugar> getLugaresdeUnEspacio(Long id);
    public List<Vehiculo> getVehiculosdeUnEspacio(Long id);

}
