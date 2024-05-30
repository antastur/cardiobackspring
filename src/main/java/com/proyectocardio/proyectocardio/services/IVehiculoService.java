package com.proyectocardio.proyectocardio.services;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Service
public interface IVehiculoService {

     public Vehiculo creaVehiculo(Vehiculo vehiculo);
    public Vehiculo cambiarVehiculo(Long id,Vehiculo vehiculo);
    public void borrarVehiculo(Vehiculo vehiculo);
    public Optional<Vehiculo> getVehiculo(Long id);
    
}
