package com.proyectocardio.proyectocardio.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectocardio.proyectocardio.exceptiones.BadRequestException;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.MensajeResponse;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.services.IEspacioService;
import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class EspacioController {

    //Inyeccion de servicios
    @Autowired
    private  IEspacioService espacioServicio;
   
    //Constructor
    public EspacioController() {
        
    }


     //Metodo y endpoint para devolver un espacio elegido por su id  
    @GetMapping("/espacios/{id}")
    public ResponseEntity<Espacio> servirEspacio(@PathVariable(value = "id") Long id){
       //Si no existe un espacio con ese id se manda mensaje a FrontEnd a través de la excepcion
       Espacio espacio=espacioServicio.getEspacio(id).orElseThrow(()-> new NotFoundException("No se encuntra espacio con esa "+id+" en BD"));
       //Si existe se manda el espacio
       return ResponseEntity.ok(espacio);
    }

     //Metodo y endpoint para devolver los lugares de un espacio elegido por su id  
     @GetMapping("espacios/lugares/{id}")
    public ResponseEntity<List<Lugar>> servirLugaresUnEspacio(@PathVariable(value = "id") Long id){
        List<Lugar> lugares=espacioServicio.getLugaresdeUnEspacio(id);
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción   
        if(lugares==null){
            throw new NotFoundException("No existe lista de espacios para cliente con id "+id);
        }
        return  ResponseEntity.ok(lugares);
    }

     //Metodo y endpoint para devolver los vehiculos de un espacio elegido por su id      
    @GetMapping("espacios/vehiculos/{id}")
    public ResponseEntity<List<Vehiculo>> servirVehiculosUnEspacio(@PathVariable(value = "id") Long id){
        List<Vehiculo> vehiculos=espacioServicio.getVehiculosdeUnEspacio(id);
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción   
        if(vehiculos==null){
            throw new NotFoundException("No existe lista de espacios para cliente con id "+id);
        }
        return  ResponseEntity.ok(vehiculos);
    }



     //Metodo y endpoint para crear un espacio 
    @PostMapping("/espacios")
    public ResponseEntity<Espacio>  createServEspacio(@RequestBody @Valid Espacio espacio) {
    
        try{
            //Si se logra crear un espacio se manda una información al FrontEnd a traves de un responeEntity
        espacioServicio.creaEspacio(espacio);
        return ResponseEntity.ok(espacio);
          
        //Si no se manda la información a traves de la excepción correspondiente
       }catch(NotFoundException nfe){

            throw  new NotFoundException("No se ha cargado ningún espacio");

        }catch(BadRequestException bre){

            throw  new BadRequestException("Hay algún problema en la validacion de campos del espacio,recuerda que es necesario introducir direccion y fecha");
        }catch(ConflictException bre){

            throw  new ConflictException("Hay algún problema en la validacion de campos del espacio,recuerda que es necesario introducir direccion y fecha");
        } 
    }
     



     //Metodo y endpoint para modificar un espacio elegido por su id  
     @PutMapping("espacios/edit/{id}")
     public  ResponseEntity<?> updateServEspacio(@PathVariable(value="id") Long id,@RequestBody @Valid Espacio espacio){

        Espacio espacioUpdate = null;
        try{
                //Si se logra modificar el espacio se manda mensaje a FrontEnd a través de ResponseEntity
                espacio.setId(id);
                espacioUpdate=espacioServicio.cambiarEspacio(id, espacio);
                return new ResponseEntity<>( MensajeResponse.builder().mensaje("Espacio creado").object(espacioUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción
            }catch(NotFoundException nfe){

                throw  new NotFoundException("No se ha cargado ningún espacio id="+id);
            }catch(BadRequestException bre){
    
                throw  new BadRequestException("Hay algún problema en la validacion de campos del espacio");
            }
       
    }






     //Metodo y endpoint para borrar un espacio elegido por su id   
    @DeleteMapping("espacios/{id}")
    public void deleteServEspacio(@PathVariable(value="id") Long id){
         try {
            //Si se logra borrar el espacio se manda mensaje a FrontEnd a través de ResponseEntity
            Espacio espacioDelete = espacioServicio.getEspacio(id).orElseThrow(()-> new NotFoundException("No se encuentra espacio con esa "+id+" en BD"));
            espacioServicio.borrarEspacio(espacioDelete);
          
       //Si no a traves de la excepción correspondiente
        } catch (NotFoundException nfe) {

            throw  new NotFoundException(nfe.getMessage());

         }catch (ConflictException cfe) {

            throw  new ConflictException(cfe.getMessage());
         }
    
    }

     }













