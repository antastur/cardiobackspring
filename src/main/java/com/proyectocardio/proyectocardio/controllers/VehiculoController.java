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
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.models.Vehiculo;
import com.proyectocardio.proyectocardio.services.ILugarService;
import com.proyectocardio.proyectocardio.services.IVehiculoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cardio/menuPrincipal/vehiculos")
public class VehiculoController {



   @Autowired
    private  IVehiculoService vehiculoServicio;
   
    public VehiculoController() {
        
    }

     @GetMapping("/{id}")
    public Vehiculo servirVehiculo(@PathVariable(value = "id") Long id){
        return vehiculoServicio.getVehiculo(id);
    }


     @PostMapping
    public void createServLugar(@RequestBody Vehiculo vehiculo) {
      
        vehiculoServicio.creaVehiculo(vehiculo);  
    }


     @PutMapping("/{id}")
     public void updateServVehiculo(@PathVariable(value="id") Long id,@RequestBody Vehiculo vehiculo){

        vehiculoServicio.cambiarVehiculo(id, vehiculo); }


        @DeleteMapping("/{id}")
    public Boolean deleteServVehiculo(@PathVariable(value="id") Long id){
        
          return vehiculoServicio.borrarVehiculo(id);
     }


}
