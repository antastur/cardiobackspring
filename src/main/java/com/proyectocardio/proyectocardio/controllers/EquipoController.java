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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/equipos")
public class EquipoController {

    @Autowired
    private  IEquipoService equipoServicio;
   
    public EquipoController() {
        
    }


     //Metodo para devolver lista con objetos alumno
    @GetMapping
    public List<Equipo> servirEquipos(){
    return  equipoServicio.getEquipos();
}


    @GetMapping("/{id}")
    public Equipo servirEquipo(@PathVariable(value = "id") Long id){
        return equipoServicio.getEquipo(id);
    }


    //Metodo para devolver lista con objetos alumno
    @GetMapping("/asignados")
    public List<Equipo> servirEquiposNoAsignados( ){
    return  equipoServicio.getEquiposNoAsignados(false);
}





     @PostMapping
    public void createServEquipo(@RequestBody Equipo equipo) {
      
        equipoServicio.creaEquipo(equipo);  
    }

     @PutMapping("/{id}")
     public /*Alumno*/ void updateServEquipo(@PathVariable(value="id") Long id,@RequestBody Equipo equipo){

         equipoServicio.cambiarEquipo(id, equipo); }


    @DeleteMapping("/{id}")
    public Boolean deleteServEquipo(@PathVariable(value="id") Long id){
        
          return equipoServicio.borrarEquipo(id);
     }






    
}
