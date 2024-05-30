package com.proyectocardio.proyectocardio.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.services.ILugarService;
import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/lugares")
public class LugarController {

    //Inyeccion de servicios
    @Autowired
    private  ILugarService lugarServicio;
   
    //Constructor
    public LugarController() {
        
    }


    //Metodo para obtener un lugar determinado según su id
     @GetMapping("/{id}")
     public ResponseEntity<?> servirLugar(@PathVariable(value = "id") Long id){
        //Si no existe un lugar con ese id se manda mensaje a FrontEnd a través de la excepcion
       Lugar lugar=lugarServicio.getLugar(id).orElseThrow(()-> new NotFoundException("No se encuntra cliente con esa "+id+" en BD"));
       //Si existe se manda el lugar
       return ResponseEntity.ok(lugar);
    }


   


     //Metodo para crear un Lugar en BD 
     @PostMapping
     public ResponseEntity<?> createServLugar(@RequestBody @Valid Lugar lugar) {
      
       try{
        //Si se logra crear un lugar se manda una información al FrontEnd a traves de un responeEntity
       lugarServicio.creaLugar(lugar); 
        return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(lugar).build(), HttpStatus.CREATED);
     // Si no se manda la información a traves de la excepción correspondiente
   }catch(DataIntegrityViolationException dive){

        throw  new ConflictException("Error al introducir CIF o repetido o vacío");
  }

 }



     //Metodo para actualizar un lugar
     @PutMapping("/{id}")
     public ResponseEntity<?> updateServLugar(@PathVariable(value="id") Long id,@RequestBody @Valid Lugar lugar){

      Lugar lugarUpdate = null;
        try{
                //Si se logra modificar el lugar se manda mensaje a FrontEnd a través de ResponseEntity
              
                lugarUpdate=lugarServicio.cambiarLugar(id,lugar);
                return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(lugarUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción correspondiente
            }catch(NotFoundException nfe){
                
                throw  new NotFoundException("No se ha cargado ningún cliente id="+id);
            }catch(BadRequestException bre){
    
              throw  new BadRequestException("Hay algún problema en la validacion de campos del cliente");
          }

       }




       //Metodo para borrar un lugar
        @DeleteMapping("/{id}")
    public void deleteServLugar(@PathVariable(value="id") Long id){
        
      try {
        //Si se logra borrar el lugar se manda mensaje a FrontEnd a través de ResponseEntity
        Lugar lugarDelete = lugarServicio.getLugar(id).orElseThrow(()-> new NotFoundException("No se encuentra lugar con esa "+id+" en BD"));
        lugarServicio.borrarLugar(lugarDelete);
      // return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(null).build(), HttpStatus.CREATED);
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
