package com.proyectocardio.proyectocardio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.services.IAlumnoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

     @Autowired
    private  IAlumnoService alumnoServicio;
   
    public AlumnoController() {
        
    }


 //Metodo para devolver lista con objetos alumno
    @GetMapping
    public List<Alumno> servirAlumnos(){
    return  alumnoServicio.getAlumnos();
}

    @GetMapping("/{id}")
    public Alumno servirAlumno(@PathVariable(value = "id") Long id){
        return alumnoServicio.getAlumno(id);
    }


    @PostMapping
    public void createServAlumno(@RequestBody Alumno alumno) {
      
        alumnoServicio.creaAlumno(alumno);  
    }
 


     @PutMapping("/{id}")
     public /*Alumno*/ void updateServAlumno(@PathVariable(value="id") Long id,@RequestBody Alumno alumno){

         alumnoServicio.cambiarAlumno(id, alumno); }


     
    @DeleteMapping("/{id}")
     public Boolean deleteServAlumno(@PathVariable(value="id") Long id){
        
          return alumnoServicio.borrarAlumno(id);
     }     
   

    
     


}
