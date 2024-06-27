package com.proyectocardio.proyectocardio.controllers;

import java.util.ArrayList;
import java.util.List;
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
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.services.IEquipoService;
import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/equipos")
public class EquipoController {

    //Inyeccion de servicios
    @Autowired
    private  IEquipoService equipoServicio;
   
    //Constructor
    public EquipoController() {
        
    }



     //Metodo para recoger de back una  lista con todos los objetos equipo
    @GetMapping
    public ResponseEntity<?>servirEquipos(){
       
       List<Equipo> equipos=new ArrayList<Equipo>();
        try{
        equipos=equipoServicio.getEquipos();
    //Si no se obtiene la lista se manda mensaje a front a traves de la excepción
        }catch (NotFoundException e){
            throw new NotFoundException("No existe lista de equipos");
        }
         
        return  ResponseEntity.ok(equipos); 
}




    //Metodo para recoger de back un equipo por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> servirEquipo(@PathVariable(value = "id") Long id){
        
        
        //Si no existe un equipo con ese id se manda mensaje a FrontEnd a través de la excepcion
       Equipo equipo=equipoServicio.getEquipo(id).orElseThrow(()-> new NotFoundException("No se encuentra equipo con esa "+id+" en BD"));
       //Si existe se manda el equipo
        
        return ResponseEntity.ok(equipo);
    }


    


    //Metodo para recoger de back lista con objetos equipos no asignados
    @GetMapping("/asignados")
    public List<Equipo> servirEquiposNoAsignados( ){
        try{
    return  equipoServicio.getEquiposNoAsignados(false);
        }catch(NotFoundException nfe){
            throw new NotFoundException("No encontrados equipos no asignados");
        }
}





    //Metodo para devolver a back un equipo y que este lo persista
     @PostMapping
     public ResponseEntity<?> createServEquipo(@RequestBody @Valid Equipo equipo) {
       
     //Si hay problemas al persistir
      try{
        equipoServicio.creaEquipo(equipo); 
        return  ResponseEntity.ok(equipo);
    }  //Si no se manda la información a traves de la excepción correspondiente
    catch(DataIntegrityViolationException dive){

            throw  new ConflictException("Error al introducir CIF o repetido o vacío");
      } 
    }
    



     //Metodo para enviar a back la id del equipo a modificar y un equipo con las propiedades a persistir
     @PutMapping("/{id}")
     public  ResponseEntity<?> updateServEquipo(@PathVariable(value="id") Long id,@RequestBody @Valid Equipo equipo){
        Equipo equipoUpdate = null;
        try{
                //Si se logra modificar el equipo se manda mensaje a FrontEnd a través de ResponseEntity
                equipo.setId(id);
                equipoUpdate=equipoServicio.cambiarEquipo(id, equipo);
                return new ResponseEntity<>(MensajeResponse.builder().mensaje("Equipo modificado").object(equipoUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción correspondiente
            }catch(NotFoundException nfe){
                throw  new NotFoundException("No se ha cargado ningún cliente id="+id);
            }catch(BadRequestException bre){
    
                throw  new BadRequestException("Hay algún problema en la validacion de campos del cliente");
            }
            }
          




    //Metodo que envía un id de Equipo a borrar de BD     
    @DeleteMapping("/{id}")
    public void deleteServEquipo(@PathVariable(value="id") Long id){
        try {
            equipoServicio.borrarEquipo(id);
        }catch(NotFoundException nfe) {

            throw  new NotFoundException(nfe.getMessage());

         }catch (ConflictException cfe) {

            throw  new ConflictException(cfe.getMessage());
         }catch (DataIntegrityViolationException cfe) {

            throw  new ConflictException(cfe.getMessage());
         }
        
          
     }






    
}
