package com.proyectocardio.proyectocardio.services;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;

@Service
public interface ILugarService {

    public Lugar creaLugar(Lugar lugar);
    public Lugar cambiarLugar(Long id,Lugar lugar);
    public Boolean borrarLugar(Long id);
    public Lugar getLugar(Long id);

}
