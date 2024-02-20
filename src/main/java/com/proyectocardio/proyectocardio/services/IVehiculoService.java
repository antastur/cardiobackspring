package com.proyectocardio.proyectocardio.services;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Vehiculo;

@Service
public interface IVehiculoService {

     public Vehiculo creaVehiculo(Vehiculo vehiculo);
    public Vehiculo cambiarVehiculo(Long id,Vehiculo vehiculo);
    public Boolean borrarVehiculo(Long id);
    public Vehiculo getVehiculo(Long id);
    
}
