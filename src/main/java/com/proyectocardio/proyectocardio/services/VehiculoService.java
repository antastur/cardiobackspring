package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;
import com.proyectocardio.proyectocardio.repositories.VehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService{

     
    @Autowired
    private VehiculoRepository vehiculoRepositorio;

    VehiculoService(){}
   
    // Metodo para crear un vehiculo en BD
    @Override
    public Vehiculo creaVehiculo(Vehiculo vehiculo) {
         
         //Si el nim telefono no esta formado por 9 digitos
         if(!vehiculo.getTelefono().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}else{
         
         return this.vehiculoRepositorio.save(vehiculo);}
    }

    // Metodo para modificar un vehiculo en BD
    @Override
    public Vehiculo cambiarVehiculo(Long id, Vehiculo vehiculo) {
        
         //Si el nim telefono no esta formado por 9 digitos
         if(!vehiculo.getTelefono().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}

         
       
         Vehiculo vehic=this.vehiculoRepositorio.findById(id).get();
       
        // vehic.setUbicacion (vehiculo.getUbicacion());
         vehic.setMarca(vehiculo.getMarca());
         vehic.setMatricula(vehiculo.getMatricula());
         vehic.setModelo(vehiculo.getModelo());
        // vehic.setTelefono(vehiculo.getTelefono());
         //vehic.setEspacio(vehiculo.getEspacio());
         //vehic.setEquipo(vehiculo.getEquipo());

         Vehiculo updatedVehiculo=this.vehiculoRepositorio.save(vehic);  
         return updatedVehiculo; 
    }

    @Override
    public Boolean borrarVehiculo(Long id) {
        // Metodo para eliminar un vehiculo de BD
        Vehiculo vehiculo;
        Boolean borrado=true;
        Optional<Vehiculo> ove=this.vehiculoRepositorio.findById(id);
        if(ove.isPresent())
        try{
            vehiculo=ove.get();
            this.vehiculoRepositorio.delete(vehiculo);
    
        }catch(Exception e){
            borrado=false;
        }
        return borrado;
    }

    @Override
    public Vehiculo getVehiculo(Long id) {
         // Metodo para obtener un vehiculo determinado según su id
         Optional <Vehiculo> ove= this.vehiculoRepositorio.findById(id);
         Vehiculo vehiculo=null;
             if(ove.isPresent()){
                vehiculo=ove.get();
                 return vehiculo;
             }else{
                 return null;
             }
    }



}
