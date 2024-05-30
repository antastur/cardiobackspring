package com.proyectocardio.proyectocardio.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;


@Service
public class LugarService implements ILugarService{

    @Autowired
    private LugarRepository lugarRepositorio;
   
    //Constructor
    LugarService(){}



    // Metodo para crear un lugar en BD
    @Override
    public Lugar creaLugar(Lugar lugar) {
         //Si el num telefono no esta formado por 9 digitos
         if(lugar.getTelefono()!=null){  
         if(!lugar.getTelefono().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}}
            
            return this.lugarRepositorio.save(lugar);
         }




    // Metodo para modificar un lugar en BD
    @Override
    public Lugar cambiarLugar(Long id, Lugar lugar) {
        //Se obliga a que si se introduce telefono sea de 9 digitos
        if(lugar.getTelefono()!=null){  
         //Si el nim telefono no esta formado por 9 digitos
        if(!lugar.getTelefono().matches("\\d{9}")){
        throw new ConflictException("Error al introducir el teléfono");

         };}
         //Se obtiene el de esa id
        Lugar lug=this.lugarRepositorio.findById(id).get();
        //y se setean las propiedades introducidas por usuario
         lug.setUbicacion(lugar.getUbicacion());
         lug.setTelefono(lugar.getTelefono());
         lug.setEspacio(lugar.getEspacio());
         lug.setEquipo(lugar.getEquipo());
        
         //SE persiste
         Lugar updatedLugar=this.lugarRepositorio.save(lug);  
         return updatedLugar; 
    }




     // Metodo para eliminar un lugar de BD
    @Override
    public void borrarLugar(Lugar lugar) {
        lugarRepositorio.delete(lugar);
      
    }



    
    
    // Metodo para obtener un lugar determinado según su id
    @Override
    public Optional<Lugar> getLugar(Long id) {
        
          return lugarRepositorio.findById(id);
       
     }

}