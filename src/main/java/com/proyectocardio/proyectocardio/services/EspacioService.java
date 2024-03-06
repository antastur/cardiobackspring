package com.proyectocardio.proyectocardio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyectocardio.proyectocardio.exceptiones.BadRequestException;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.repositories.EspacioRepository;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;
import com.proyectocardio.proyectocardio.repositories.VehiculoRepository;


//Clase que implementa la interface de los servicios para las operaciones con clientes
@Service
public class EspacioService implements IEspacioService{


    //Inyección de repositorios
    @Autowired
    private EspacioRepository espacioRepositorio;
    @Autowired
    private VehiculoRepository vehiculoRepositorio;
    @Autowired
    private LugarRepository lugarRepositorio;

   
    //Constructor
    EspacioService(){}
   

    //Método que usa repositorio para guardar un espacio en BD
    @Override
    public Espacio creaEspacio(@RequestBody Espacio espacio) throws BadRequestException,ConflictException{
        
        if(!espacio.getNumTelef().matches("\\d{9}")){
          throw new ConflictException("Error al introducir el teléfono");}
        Espacio espac= this.espacioRepositorio.save(espacio);

      return espac;
    }
  
    // Metodo para modificar un espacio en BD
    @Override
    public Espacio cambiarEspacio(Long id, Espacio espacio) throws ConflictException,NotFoundException,BadRequestException {
       
      //Si el nim telefono no esta formado por 9 digitos
      if(!espacio.getNumTelef().matches("\\d{9}")){
        throw new ConflictException("Error al introducir el teléfono");

         };
       //Obtiene un espacio en concreto de BD usando su id
         Espacio espac=this.espacioRepositorio.findById(id).get();
         //Modifica cada uno de sus atributos con los obtenidos por parametro 
         espac.setDireccion(espacio.getDireccion());
         espac.setEmail(espacio.getEmail());
         espac.setFechRegDga(espacio.getFechRegDga());
         espac.setHorario(espacio.getHorario());
         espac.setNumTelef(espacio.getNumTelef());
         //Se instancia una lista de lugares y se rellena con la del espacio obtenido por parametro
         List<Lugar> lugares=new ArrayList<Lugar>() ;
         lugares.addAll(espacio.getLugares());
        //Cada uno de los lugares de un espacio se setea a este
         for(Lugar lugar : lugares){
            lugar.setEspacio(espacio);

         }
       //Se persiste
       Espacio updatedEspacio=this.espacioRepositorio.save(espac);  
       return updatedEspacio; 
    }


     // Metodo para eliminar un espacio de BD
    @Override
    public void borrarEspacio(Espacio espacio) throws ConflictException,NotFoundException{
      espacioRepositorio.delete(espacio);
    }




    //Método para obtener un espacio determinado según su id
    @Override
     public Optional<Espacio> getEspacio(Long id) throws NotFoundException {
        return espacioRepositorio.findById(id);  
      }



     //Metodo para obtener todos los lugares de un espacio determinado elegido por su id
    @Override 
     public List<Lugar> getLugaresdeUnEspacio(Long id) throws NotFoundException {
        //Usando el repositorio se obtiene el espacio por su id
        Espacio espacio=this.espacioRepositorio.findById(id).get();
         //Se busca lista con repositorio de vehiculos
         return this.lugarRepositorio.findByEspacioOrderById(espacio);

      /* 
         //Se crea una lista de lugares
        List<Lugar> lugares = new ArrayList<Lugar>();
        //Usando el repositorio se obtiene el espacio por su id
        Espacio espacio= this.espacioRepositorio.findById(id).get();
        //Se llena la lista espacios con las de ese cliente y se devuelve
        lugares.addAll(espacio.getLugares());
        return lugares; */
    }



     //Metodo para obtener todos los vehiculos de un espacio determinado elegido por su id
    @Override
    public List<Vehiculo> getVehiculosdeUnEspacio(Long id) {
        //Usando el repositorio se obtiene el espacio por su id
        Espacio espacio=this.espacioRepositorio.findById(id).get();
        //Se busca lista con repositorio de vehiculos
        return this.vehiculoRepositorio.findAllByEspacio(espacio);

       
    }


   
  






}
