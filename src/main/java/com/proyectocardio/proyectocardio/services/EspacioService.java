package com.proyectocardio.proyectocardio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;
import com.proyectocardio.proyectocardio.repositories.EspacioRepository;

@Service
public class EspacioService implements IEspacioService{



     @Autowired
    private EspacioRepository espacioRepositorio;

    EspacioService(){}
   

    @Override
    public List<Espacio> getEspacios() {
       // Metodo para obtener todos los equipos de BD
        List<Espacio> espacios=this.espacioRepositorio.findAll();
        return espacios;
    }

    @Override
    public Espacio creaEspacio(Espacio espacio) {
        // Metodo para crear un equipo en BD
        return this.espacioRepositorio.save(espacio);
    }
  

    @Override
    public Espacio cambiarEspacio(Long id, Espacio espacio) {
         // Metodo para modificar un cliente en BD
       
         Espacio espac=this.espacioRepositorio.findById(id).get();
       
         espac.setDireccion(espacio.getDireccion());
         espac.setEmail(espacio.getEmail());
         espac.setFechRegDga(espacio.getFechRegDga());
         espac.setHorario(espacio.getHorario());
         espac.setNumTelef(espacio.getNumTelef());
         List<Lugar> lugares=new ArrayList<Lugar>() ;
         lugares.addAll(espacio.getLugares());
         for(Lugar lugar : lugares){
            lugar.setEspacio(espacio);

         }
       //  espac.setCliente(espacio.getCliente());
      /*  List<Lugar> lugares=new ArrayList<Lugar>();
         lugares.addAll( espacio.getLugares());
         for(Lugar lugar: lugares){
            lugar.setEspacio(espacio);
  }
        */ 
      
       Espacio updatedEspacio=this.espacioRepositorio.save(espac);  
       return updatedEspacio; 
    }

    @Override
    public Boolean borrarEspacio(Long id) {
       // Metodo para eliminar un espacio de BD
        Espacio espacio;
        Boolean borrado=true;
        Optional<Espacio> oes=this.espacioRepositorio.findById(id);
        if(oes.isPresent())
        try{
            espacio=oes.get();
            this.espacioRepositorio.delete(espacio);
    
        }catch(Exception e){
            borrado=false;
        }
        return borrado;
    }

    @Override
     public Espacio getEspacio(Long id) {
            // Metodo para obtener un equipo determinado según su id
            Optional <Espacio> oEspac= this.espacioRepositorio.findById(id);
            Espacio espacio=null;
                if(oEspac.isPresent()){
                    espacio=oEspac.get();
                    return espacio;
                }else{
                    return null;
                }
      }

    @Override 
     public List<Lugar> getLugaresdeUnEspacio(Long id){
       
        List<Lugar> lugares = new ArrayList<Lugar>();
        Espacio espacio= this.espacioRepositorio.findById(id).get();
        lugares.addAll(espacio.getLugares());
        return lugares;

      }







}
