package com.proyectocardio.proyectocardio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.services.IClienteService;
import com.proyectocardio.proyectocardio.services.IEquipoService;

@CrossOrigin(origins = "http://localhost:4200,http://localhost:8080")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class ClienteController {

     @Autowired
    private  IClienteService clienteServicio;
    private  IEquipoService equipoServicio;
   
    public ClienteController() {
        
    }


      //Metodo para devolver lista con objetos cliente
    @GetMapping("/clientes")
    public List<Cliente> servirClientes(){
    return  clienteServicio.getClientes();
}

     @GetMapping("/clientes/{id}")
    public Cliente servirCliente(@PathVariable(value = "id") Long id){
        return clienteServicio.getCliente(id);
    }

    
    @GetMapping("/clientes/espacios/{id}")
    public List<Espacio> servirEspaciosUnCliente(@PathVariable(value = "id") Long id){

        return clienteServicio.getEspaciosdeUnCliente(id);
    }


    @GetMapping("/clientes/cursos/{id}")
    public List<Curso> servirCursosUnCliente(@PathVariable(value = "id") Long id){

        return clienteServicio.getCursosdeUnCliente(id);
    }


    
     @PostMapping("/clientes")
    public void createServCliente(@RequestBody Cliente cliente) {
      
        clienteServicio.creaCliente(cliente);  
    }


    @PutMapping("/clientes/{id}")
     public  void updateServCliente(@PathVariable(value="id") Long id,@RequestBody Cliente cliente){

         clienteServicio.cambiarCliente(id, cliente); }

/* 
     @PostMapping("/equipos")
         public void createServEquipo(@RequestBody Equipo equipo) {
           
             equipoServicio.creaEquipo(equipo);  
         }
     
     
     @PutMapping("/equipos/{id}")
          public  void updateServEquipo(@PathVariable(value="id") Long id,@RequestBody Equipo equipo){
     
              equipoServicio.cambiarEquipo(id, equipo);
            }


*/

}
