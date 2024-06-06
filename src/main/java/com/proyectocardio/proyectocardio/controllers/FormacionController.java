package com.proyectocardio.proyectocardio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectocardio.proyectocardio.exceptiones.MensajeResponse;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.FormacionDto;
import com.proyectocardio.proyectocardio.services.ICursoService;
import com.proyectocardio.proyectocardio.services.IformacionService;


//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class FormacionController {

    @Autowired
    IformacionService formacionService;

    


    //Constructor
    public FormacionController() {
        
    }


        //Metodo y endpoint para devolver lista con objetos formacion
        @GetMapping("/cursos/{id}")
        public ResponseEntity<?> getFormacionesByCurso(@PathVariable(value = "id") Long id){
            List<FormacionDto> formacionesDto= formacionService.getFormacionesByCurso(id);

       return new ResponseEntity<>(MensajeResponse.builder().mensaje("Formaciones obtenidas").object(formacionesDto).build(), HttpStatus.OK);
}
}