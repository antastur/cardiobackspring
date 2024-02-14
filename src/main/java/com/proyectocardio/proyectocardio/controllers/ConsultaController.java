package com.proyectocardio.proyectocardio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.services.IEquipoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/consultas")
public class ConsultaController {


  @Autowired
    private  IEquipoService equipoServicio;
   
    public ConsultaController() {
        
    }


   //Metodo para devolver numero de equipos no asignados
    @GetMapping
    public Long contarEquiposNoAsignados(){
        return null;
      
}


 //Metodo para devolver numero de equipos usados
 @GetMapping("/usados")
 public Long contarEquiposUsados(){
     return null;
   
}















}
