package com.proyectocardio.proyectocardio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.repositories.EspacioRepository;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;

@Transactional
@Service
public class LugarService implements ILugarService{



    
    @Autowired
    private LugarRepository lugarRepositorio;

    LugarService(){}
   

    // Metodo para crear un lugar en BD

    @Override
    public Lugar creaLugar(Lugar lugar) {
         //Si el nim telefono no esta formado por 9 digitos
         if(!lugar.getTelefono().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}else{
         
         return this.lugarRepositorio.save(lugar);}
    }

    @Override
    public Lugar cambiarLugar(Long id, Lugar lugar) {
          
         //Si el nim telefono no esta formado por 9 digitos
        if(!lugar.getTelefono().matches("\\d{9}")){
        throw new ConflictException("Error al introducir el teléfono");

         };

         // Metodo para modificar un cliente en BD

         Lugar lug=this.lugarRepositorio.findById(id).get();
        
         lug.setUbicacion(lugar.getUbicacion());
         lug.setTelefono(lugar.getTelefono());
         lug.setEspacio(lugar.getEspacio());
         lug.setEquipo(lugar.getEquipo());
        
 
         Lugar updatedLugar=this.lugarRepositorio.save(lug);  
         return updatedLugar; 
    }

    @Override
    public Boolean borrarLugar(Long id) {
        // Metodo para eliminar un espacio de BD
        Lugar lugar;
        Boolean borrado=true;
        Optional<Lugar> olu=this.lugarRepositorio.findById(id);
        if(olu.isPresent())
        try{
            lugar=olu.get();
            this.lugarRepositorio.delete(lugar);
    
        }catch(Exception e){
            borrado=false;
        }
        return borrado;
    }

    @Override
    public Lugar getLugar(Long id) {
        // Metodo para obtener un lugar determinado según su id
            Optional <Lugar> oLug= this.lugarRepositorio.findById(id);
            Lugar lugar=null;
                if(oLug.isPresent()){
                    lugar=oLug.get();
                    return lugar;
                }else{
                    return null;
                }
    }

}
