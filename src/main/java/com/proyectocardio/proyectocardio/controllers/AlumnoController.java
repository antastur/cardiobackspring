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
import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.services.IAlumnoService;

import jakarta.validation.Valid;


//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class AlumnoController {

    //Inyeccion de servicios
     @Autowired
    private  IAlumnoService alumnoServicio;
   
    //Constructor
    public AlumnoController() {
        
    }


    //Metodo y endpoint para devolver lista con objetos alumno
    @GetMapping("/alumnos")
     public ResponseEntity<?> servirAlumnos(){

        List<Alumno> alumnos=null;

        alumnos=alumnoServicio.getAlumnos();
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción
        if(alumnos==null){
            throw new NotFoundException("No existe lista de alumnos");
           }
        //Si hay lista se manda esta al FrontEnd
       return new ResponseEntity<>(MensajeResponse.builder().mensaje("Alumno creado").object(alumnos).build(), HttpStatus.CREATED);
        
        }



    //Metodo y endpoint para devolver un alumno elegido por su id 
    @GetMapping("/alumnos/{id}")
    public  ResponseEntity<?>  servirAlumno(@PathVariable(value = "id") Long id){
        //Si no existe un alumno con ese id se manda mensaje a FrontEnd a través de la excepcion
        Alumno alumno=alumnoServicio.getAlumno(id).orElseThrow(()-> new NotFoundException("No se encuntra alumno con esa "+id+" en BD"));
        //Si existe se manda el cliente
        return new ResponseEntity<>(MensajeResponse.builder().mensaje("Alumno creado").object(alumno).build(), HttpStatus.CREATED);
     }




    //Metodo y endpoint para crear un alumno  
    @PostMapping("/alumnos")
     public ResponseEntity<?> createServAlumno(@RequestBody @Valid Alumno alumno) {
        
        Alumno alumnoSave=null;
        try{
            //Si se logra crear un alumno se manda una información al FrontEnd a traves de un responeEntity
            alumnoSave=alumnoServicio.creaAlumno(alumno); 
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Alumno creado").object(alumnoSave).build(), HttpStatus.CREATED);
          
        //Si no se manda la información a traves de la excepción correspondiente
       }catch(NotFoundException nfe){

            throw  new NotFoundException("No se ha cargado ningún alumno");
           
        }catch(BadRequestException bre){

            throw  new BadRequestException("Hay algún problema en la validacion de campos del alumno");
        }catch(ConflictException bre){

            throw  new ConflictException("Hay algún problema en la validacion de campos del alumno");
        }
    
    }



     //Metodo y endpoint para modificar un alumno elegido por su id  
     @PutMapping("/alumnos/{id}")
     public  ResponseEntity<?> updateServAlumno(@PathVariable(value="id") Long id,@RequestBody @Valid Alumno alumno){

        Alumno alumnoUpdate = null;
        try{
                //Si se logra modificar el alumno se manda mensaje a FrontEnd a través de ResponseEntity
                alumno.setId(id);
                alumnoUpdate=alumnoServicio.creaAlumno(alumno);
                return new ResponseEntity<>(MensajeResponse.builder().mensaje("Alumno creado").object(alumnoUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción correspondiente
            }catch(NotFoundException nfe){

                throw  new NotFoundException("No se ha cargado ningún alumno id="+id);
            }catch(BadRequestException bre){
    
                throw  new BadRequestException("Hay algún problema en la validacion de campos del alumno");
            }
     }


    //Metodo y endpoint para borrar un alumno elegido por su id 
    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?> deleteServAlumno(@PathVariable(value="id") Long id){
        try {
            //Si se logra borrar el alumno se manda mensaje a FrontEnd a través de ResponseEntity
            Alumno alumnoDelete = alumnoServicio.getAlumno(id).orElseThrow(()-> new NotFoundException("No se encuentra alumno con esa "+id+" en BD"));
            alumnoServicio.borrarAlumno(alumnoDelete);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(null).build(), HttpStatus.CREATED);
       //Si no a traves de la excepción correspondiente
        } catch (NotFoundException nfe) {

            throw  new NotFoundException(nfe.getMessage());

         }catch (ConflictException cfe) {

            throw  new ConflictException(cfe.getMessage());
         }
    
    }

   

    
     


}
