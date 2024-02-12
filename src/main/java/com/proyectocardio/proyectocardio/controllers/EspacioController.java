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

import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.services.IEquipoService;
import com.proyectocardio.proyectocardio.services.IEspacioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/espacios")
public class EspacioController {

      @Autowired
    private  IEspacioService espacioServicio;
   
    public EspacioController() {
        
    }



      //Metodo para devolver lista con objetos alumno
    @GetMapping
    public List<Espacio> servirEspacios(){
    return  espacioServicio.getEspacios();
}


    @GetMapping("/{id}")
    public Espacio servirEspacio(@PathVariable(value = "id") Long id){
        return espacioServicio.getEspacio(id);
    }


     @GetMapping("/lugares/{id}")
    public List<Lugar> servirLugaresUnEspacio(@PathVariable(value = "id") Long id){

        return espacioServicio.getLugaresdeUnEspacio(id);
    }





    @PostMapping
    public void createServEspacio(@RequestBody Espacio espacio) {
      
        espacioServicio.creaEspacio(espacio);  
    }

     @PutMapping("/edit/{id}")
     public void updateServEspacio(@PathVariable(value="id") Long id,@RequestBody Espacio espacio){

        espacioServicio.cambiarEspacio(id, espacio); }


    @DeleteMapping("/{id}")
    public Boolean deleteServEspacio(@PathVariable(value="id") Long id){
        
          return espacioServicio.borrarEspacio(id);
     }












}