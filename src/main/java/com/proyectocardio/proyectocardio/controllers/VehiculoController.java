package com.proyectocardio.proyectocardio.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.services.IVehiculoService;

import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/vehiculos")
public class VehiculoController {


    //Inyeccion de servicios
    @Autowired
    private  IVehiculoService vehiculoServicio;
   
    //Constructor
    public VehiculoController() {
        
    }

     @GetMapping("/{id}")
    public Vehiculo servirVehiculo(@PathVariable(value = "id") Long id){
        return vehiculoServicio.getVehiculo(id);
    }


     @PostMapping
    public void createServVehiculo(@RequestBody @Valid Vehiculo vehiculo) {
      
        vehiculoServicio.creaVehiculo(vehiculo);  
    }


     @PutMapping("/{id}")
     public void updateServVehiculo(@PathVariable(value="id") Long id,@RequestBody @Valid Vehiculo vehiculo){

        vehiculoServicio.cambiarVehiculo(id, vehiculo); }


        @DeleteMapping("/{id}")
    public Boolean deleteServVehiculo(@PathVariable(value="id") Long id){
        
          return vehiculoServicio.borrarVehiculo(id);
     }


}
