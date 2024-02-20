package com.proyectocardio.proyectocardio.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.services.IEquipoService;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/consultas")
public class ConsultaController {

  //Inyeccion de servicios
  @Autowired
    private  IEquipoService equipoServicio;
   
    //Constructor
    public ConsultaController() {
        
    }


    //Metodo y endpoint para devolver lista con objetos equipo con propiedad condicionUsado=true
    @GetMapping("/usados")
    public List<Equipo> servirEquiposUsados(){
     List<Equipo> equipos=this.equipoServicio.findByCondicionUsado(true);
    return equipos;
 }


     //Metodo para devolver lista con objetos Equipo
     @GetMapping("/exterior")
     public List<Equipo> servirEquiposExterior(){
      List<Equipo> equipos=this.equipoServicio.findByCondicionUsado(true);
     return equipos;
  }




    //Metodo para devolver lista con objetos Equipo
    @GetMapping("/caducidad")
    public List<Equipo> servirEquiposCaducos(){
     List<Equipo> equipos=this.equipoServicio.findByFechaCaducidadBefore(LocalDate.now().plusYears(1));
    return equipos;
 }








}
