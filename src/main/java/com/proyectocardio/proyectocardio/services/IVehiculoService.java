package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Service
public interface IVehiculoService {

     public Vehiculo creaVehiculo(Vehiculo vehiculo);
    public Vehiculo cambiarVehiculo(Long id,Vehiculo vehiculo);
    public Boolean borrarVehiculo(Long id);
    public Vehiculo getVehiculo(Long id);
    
}
