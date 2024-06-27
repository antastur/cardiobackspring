package com.proyectocardio.proyectocardio.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.proyectocardio.proyectocardio.exceptiones.BadRequestException;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.MensajeResponse;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.services.IVehiculoService;
import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/vehiculos")
public class VehiculoController {


    //Inyeccion de servicios
    @Autowired
    private  IVehiculoService vehiculoServicio;
   
    //Constructor
    public VehiculoController() {
        
    }
    //Metodo para obtener un vehiculo determinado según su id
     @GetMapping("/{id}")
    public ResponseEntity<?> servirVehiculo(@PathVariable(value = "id") Long id){
       //Si no existe un vehiculo con ese id se manda mensaje a FrontEnd a través de la excepcion
        Vehiculo vehiculo= vehiculoServicio.getVehiculo(id).orElseThrow(()-> new NotFoundException("No se encuntra vehiculo con esa "+id+" en BD"));
       //Si existe se manda el vehiculo
        return ResponseEntity.ok(vehiculo);
    }

    //Metodo para crear un Vehiculo en BD 
     @PostMapping
    public ResponseEntity<?> createServVehiculo(@RequestBody @Valid Vehiculo vehiculo) {
      
        try{
            //Si se logra crear un vehiculo se manda una información al FrontEnd a traves de un responeEntity
             vehiculoServicio.creaVehiculo(vehiculo); 
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Vehiculo creado").object(vehiculo).build(), HttpStatus.CREATED);
         // Si no se manda la información a traves de la excepción correspondiente
         }catch(DataIntegrityViolationException dive){

             throw  new ConflictException("Error al introducir CIF o repetido o vacío");
         }
    }




     //Metodo para actualizar un vehiculo
     @PutMapping("/{id}")
     public ResponseEntity<?>  updateServVehiculo(@PathVariable(value="id") Long id,@RequestBody @Valid Vehiculo vehiculo){

         Vehiculo vehiculoUpdate = null;
        try{
                //Si se logra modificar el vehiculo se manda mensaje a FrontEnd a través de ResponseEntity
    
                vehiculoUpdate=vehiculoServicio.cambiarVehiculo(id,vehiculo);
                return new ResponseEntity<>(MensajeResponse.builder().mensaje("Vehiculo creado").object(vehiculoUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción correspondiente
            }catch(NotFoundException nfe){
                
                throw  new NotFoundException("No se ha cargado ningún cliente id="+id);
            }catch(BadRequestException bre){
    
              throw  new BadRequestException("Hay algún problema en la validacion de campos del cliente");
          }   



         }

 //Metodo para borrar un vehiculo
        @DeleteMapping("/{id}")
    public void deleteServLugar(@PathVariable(value="id") Long id){
        
      try {
        //Si se logra borrar el vehiculo se manda mensaje a FrontEnd a través de ResponseEntity
        Vehiculo vehiculoDelete = vehiculoServicio.getVehiculo(id).orElseThrow(()-> new NotFoundException("No se encuentra vehiculo con esa "+id+" en BD"));
        vehiculoServicio.borrarVehiculo(vehiculoDelete);
      // return new ResponseEntity<>(MensajeResponse.builder().mensaje("Vehiculo creado").object(null).build(), HttpStatus.CREATED);
   //Si no a traves de la excepción correspondiente
    } catch (NotFoundException nfe) {

      throw  new NotFoundException(nfe.getMessage());

   }catch (ConflictException cfe) {

      throw  new ConflictException(cfe.getMessage());
   }catch (DataIntegrityViolationException cfe) {

      throw  new ConflictException(cfe.getMessage());
   }
   
     }

}
