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

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.services.IClienteService;

@CrossOrigin(origins = "http://localhost:4200,http://localhost:8080")
@RestController
@RequestMapping("/cardio/menuPrincipal/clientes")
public class ClienteController {

     @Autowired
    private  IClienteService clienteServicio;
   
    public ClienteController() {
        
    }


      //Metodo para devolver lista con objetos cliente
    @GetMapping
    public List<Cliente> servirClientes(){
    return  clienteServicio.getClientes();
}

     @GetMapping("/{id}")
    public Cliente servirCliente(@PathVariable(value = "id") Long id){
        return clienteServicio.getCliente(id);
    }

    
     @PostMapping
    public void createServCliente(@RequestBody Cliente cliente) {
      
        clienteServicio.creaCliente(cliente);  
    }


    @PutMapping("/{id}")
     public  void updateServCliente(@PathVariable(value="id") Long id,@RequestBody Cliente cliente){

         clienteServicio.cambiarCliente(id, cliente); }

}
