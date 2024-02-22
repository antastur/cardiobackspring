package com.proyectocardio.proyectocardio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectocardio.proyectocardio.exceptiones.BadRequestException;
import com.proyectocardio.proyectocardio.exceptiones.MensajeResponse;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.services.IClienteService;


import jakarta.validation.Valid;

//Clase que define los endpoints de comunicacion con el Front
@CrossOrigin(origins = "http://localhost:4200,http://localhost:8080")
@RestController
@RequestMapping("/cardio/menuPrincipal")
public class ClienteController {



    //Inyeccion de servicios
     @Autowired
    private  IClienteService clienteServicio;
   
   


    //Constructor
    public ClienteController() {
         }



     //Metodo y endpoint para devolver lista con objetos cliente
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> servirClientes(){
        List<Cliente> clientes=clienteServicio.getClientes();
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción
        if(clientes==null){
            throw new NotFoundException("No existe lista de clientes");
           }
        //Si hay lista se manda esta al FrontEnd
        return  ResponseEntity.ok(clientes);
        }





     //Metodo y endpoint para devolver un cliente elegido por su id  
     @GetMapping("/clientes/{id}")
     public  ResponseEntity<Cliente>  servirCliente(@PathVariable(value = "id") Long id){
       Cliente cliente=clienteServicio.getCliente(id);
       //Si no existe un cliente con ese id se manda mensaje a FrontEnd a través de la excepcion
       if(cliente==null){
        
        throw new NotFoundException("Cliente "+ id);
        }
       //Si existe se manda el cliente
       return ResponseEntity.ok(cliente);
    }
    




    
    //Metodo y endpoint para devolver los espacios de un cliente elegido por su id  
    @GetMapping("/clientes/espacios/{id}")
    public ResponseEntity<List<Espacio>> servirEspaciosUnCliente(@PathVariable(value = "id") Long id){
        List<Espacio> espacios=clienteServicio.getEspaciosdeUnCliente(id);
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción
        if(espacios==null){
            throw new NotFoundException("No existe lista de espacios");
        }
        return  ResponseEntity.ok(espacios);
    }






    //Metodo y endpoint para devolver los cursos de un cliente elegido por su id  
    @GetMapping("/clientes/cursos/{id}")
    public ResponseEntity<List<Curso>> servirCursosUnCliente(@PathVariable(value = "id") Long id){

        List<Curso> cursos=clienteServicio.getCursosdeUnCliente(id);
        //Si no se obtiene la lista se manda mensaje a front a traves de la excepción
        if(cursos==null){
            throw new NotFoundException("No existe lista de cursos");
        }
        return ResponseEntity.ok(cursos);
    }





    //Metodo y endpoint para crear un cliente  
     @PostMapping("/clientes")
     public ResponseEntity<?> createServCliente(@RequestBody @Valid Cliente cliente) {
       
        Cliente clienteSave=null;
        try{
            //Si se logra crear un cliente se manda una información al FrontEnd a traves de un responeEntity
            clienteSave=clienteServicio.creaCliente(cliente); 
            
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(clienteSave).build(), HttpStatus.CREATED);
        //Si no se manda la información a traves de la excepción correspondiente
        }catch(NotFoundException nfe){

            throw  new NotFoundException("No se ha cargado ningún cliente");
        }catch(BadRequestException bre){

            throw  new BadRequestException("Hay algún problema en la validacion de campos del cliente");
        }
           
    }





    //Metodo y endpoint para modificar un cliente elegido por su id  
    @PutMapping("/clientes/{id}")
     public  ResponseEntity<?> updateServCliente(@PathVariable(value="id") Long id,@RequestBody @Valid Cliente cliente){

        Cliente clienteUpdate = null;
        try{
                //Si se logra modificar el cliente se manda mensaje a FrontEnd a través de ResponseEntity
                cliente.setId(id);
                clienteUpdate=clienteServicio.creaCliente(cliente);
                return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(clienteUpdate).build(), HttpStatus.CREATED);
             //Si no a traves de la excepción correspondiente
            }catch(NotFoundException nfe){

                throw  new NotFoundException("No se ha cargado ningún cliente id="+id);
            }catch(BadRequestException bre){
    
                throw  new BadRequestException("Hay algún problema en la validacion de campos del cliente");
            }
     }




    //Metodo y endpoint para borrar un cliente elegido por su id   
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteServCliente(@PathVariable(value="id") Long id){
        try {
            //Si se logra borrar el cliente se manda mensaje a FrontEnd a través de ResponseEntity
            Cliente clienteDelete = clienteServicio.getCliente(id);
            clienteServicio.borrarCliente(clienteDelete);
            return new ResponseEntity<>(MensajeResponse.builder().mensaje("Cliente creado").object(null).build(), HttpStatus.CREATED);
       //Si no a traves de la excepción correspondiente
        } catch (DataAccessException exDt) {
            throw  new BadRequestException(exDt.getMessage());
        }
    
    }



}
