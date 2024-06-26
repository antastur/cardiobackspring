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

import com.proyectocardio.proyectocardio.exceptiones.MensajeResponse;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.CursoDto;
import com.proyectocardio.proyectocardio.repositories.CursoRepository;
import com.proyectocardio.proyectocardio.services.ICursoService;
import com.proyectocardio.proyectocardio.services.IformacionService;

import jakarta.validation.Valid;


//Clase que define los endpoints de comunicacion con el Front
//@CrossOrigin(origins = "http://localhost:4200,http://localhost:8080")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class CursoController  {


    //Inyeccion de servicios
     @Autowired
     private ICursoService cursoServicio ;
  
    
     //Constructor
     public CursoController() {
        
     }

     //Metodo para devolver lista con objetos cliente
    @GetMapping("/cursos")
    public List<CursoDto> getCursos() {
        return cursoServicio.getCursos();
    }



    @PostMapping
    public void creaCurso(@RequestBody @Valid Curso curso ) {
        cursoServicio.creaCurso(curso);
     
    }

    @PutMapping("/{id}")
    public void cambiarCurso(@PathVariable(value="id") Long id,@RequestBody @Valid Curso curso) {
        cursoServicio.cambiarCurso(id, curso); }
    

    @DeleteMapping("/{id}")
    public Boolean borrarCurso(@PathVariable(value="id") Long id) {
        return cursoServicio.borrarCurso(id);

    }

   // @GetMapping("/cursos/{id}")
   // public Curso getCurso(Long id) {
     //   return cursoServicio.getCurso(id);
   // }
    @GetMapping("/cursos/{id}")
     public  ResponseEntity<?>  servirAlumno(@PathVariable(value = "id") Long id){
        //Si no existe un alumno con ese id se manda mensaje a FrontEnd a través de la excepcion
        Curso curso=cursoServicio.getCurso(id).orElseThrow(()-> new NotFoundException("No se encuntra curso con esa "+id+" en BD"));
        //Si existe se manda el espacio
        return ResponseEntity.ok(curso);
     }

}
