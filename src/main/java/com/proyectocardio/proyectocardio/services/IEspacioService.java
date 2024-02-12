package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Service
public interface IEspacioService {

    public List<Espacio> getEspacios();
    public Espacio creaEspacio(Espacio espacio);
    public Espacio cambiarEspacio(Long id,Espacio espacio);
    public Boolean borrarEspacio(Long id);
    public Espacio getEspacio(Long id);
    public List<Lugar> getLugaresdeUnEspacio(Long id);

}
