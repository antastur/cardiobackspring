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
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.services.IEquipoService;
import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
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
    public List<Equipo> servirEquipos(){
    return  equipoServicio.getEquipos();
}

    //Metodo para recoger de back un equipo por su id
    @GetMapping("/{id}")
    public Equipo servirEquipo(@PathVariable(value = "id") Long id){
        return equipoServicio.getEquipo(id);
    }


    //Metodo para recoger de back lista con objetos equipos no asignados
    @GetMapping("/asignados")
    public List<Equipo> servirEquiposNoAsignados( ){
    return  equipoServicio.getEquiposNoAsignados(false);
}


    //Metodo para devolver a back un equipo y que este lo persista
     @PostMapping
    public void createServEquipo(@RequestBody @Valid Equipo equipo) {
      
        equipoServicio.creaEquipo(equipo);  
    }
    
     //Metodo para enviar a back la id del equipo a modificar y un equipo con las propiedades a persistir
     @PutMapping("/{id}")
     public  void updateServEquipo(@PathVariable(value="id") Long id,@RequestBody @Valid Equipo equipo){

         equipoServicio.cambiarEquipo(id, equipo); }


    //Metodo que envía un id de Equipo a borrar de BD     
    @DeleteMapping("/{id}")
    public Boolean deleteServEquipo(@PathVariable(value="id") Long id){
        
          return equipoServicio.borrarEquipo(id);
     }






    
}
