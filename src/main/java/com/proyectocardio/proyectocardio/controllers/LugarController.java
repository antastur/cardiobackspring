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
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.services.IEspacioService;
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




     @GetMapping("/{id}")
    public Lugar servirLugar(@PathVariable(value = "id") Long id){
        return lugarServicio.getLugar(id);
    }


     @PostMapping
    public void createServLugar(@RequestBody @Valid Lugar lugar) {
      
      lugarServicio.creaLugar(lugar);  
    }


     @PutMapping("/{id}")
     public void updateServLugar(@PathVariable(value="id") Long id,@RequestBody @Valid Lugar lugar){

      lugarServicio.cambiarLugar(id, lugar); }


        @DeleteMapping("/{id}")
    public Boolean deleteServLugar(@PathVariable(value="id") Long id){
        
          return lugarServicio.borrarLugar(id);
     }
}
