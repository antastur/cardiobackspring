package com.proyectocardio.proyectocardio.services;


import java.util.Optional;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Lugar;

@Service
public interface ILugarService {

    public Lugar creaLugar(Lugar lugar);
    public Lugar cambiarLugar(Long id,Lugar lugar);
    public void borrarLugar(Lugar lugar);
    public Optional<Lugar> getLugar(Long id);
    
    }
