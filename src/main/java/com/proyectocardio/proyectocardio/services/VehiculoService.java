package com.proyectocardio.proyectocardio.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.repositories.VehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService{

     
    @Autowired
    private VehiculoRepository vehiculoRepositorio;

    //Constructor
    VehiculoService(){}
   



    // Metodo para crear un vehiculo en BD
    @Override
    public Vehiculo creaVehiculo(Vehiculo vehiculo) {
         
         //Se obliga a que si se introduce un tlfno tenga formato de 9 números
        if(vehiculo.getTelefono()!=null){
         if(!vehiculo.getTelefono().matches("\\d{9}")){
                
            throw new ConflictException("Error al introducir el teléfono");}}
           
         
        return this.vehiculoRepositorio.save(vehiculo);
    }
             


    // Metodo para modificar un vehiculo en BD
    @Override
    public Vehiculo cambiarVehiculo(Long id, Vehiculo vehiculo) {
         
         //Se obliga a que si se introduce un tlfno tenga formato de 9 números
        if(vehiculo.getTelefono()!=null){
         //Si el nim telefono no esta formado por 9 digitos
         if(!vehiculo.getTelefono().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}}
          //Se obtiene el vehiculo a cambiar de BD
          Vehiculo vehic=this.vehiculoRepositorio.findById(id).get();
       
         //Se setea con datos introducidos por usuario
         vehic.setMarca(vehiculo.getMarca());
         vehic.setMatricula(vehiculo.getMatricula());
         vehic.setModelo(vehiculo.getModelo());
       
         //Se persiste
         Vehiculo updatedVehiculo=this.vehiculoRepositorio.save(vehic);  
         return updatedVehiculo; 
    }





    //Metodo para borrar un vehiculo
    @Override
    public void borrarVehiculo(Vehiculo vehiculo) {
        
        vehiculoRepositorio.delete(vehiculo);
      
    }



    // Metodo para obtener un vehiculo determinado según su id
    @Override
    public Optional<Vehiculo> getVehiculo(Long id) {
         
         return vehiculoRepositorio.findById(id);
    } 



}
