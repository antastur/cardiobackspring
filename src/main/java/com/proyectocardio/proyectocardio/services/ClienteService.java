package com.proyectocardio.proyectocardio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.exceptiones.BadRequestException;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.repositories.ClienteRepository;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;



//Clase que implementa la interface de los servicios para las operaciones con clientes

@Service
public class ClienteService implements IClienteService{

    //Inyección de repositorios
    @Autowired
    private ClienteRepository clienteRepositorio;
    private EquipoRepository equipoRepositorio;
    
    //Constructor
    ClienteService(){}


    //Metodo que hace uso del repositorio para obtener una lista de todos los clientes de BD
    @Override
    public List<Cliente> getClientes() {
       
        List<Cliente> clientes=this.clienteRepositorio.findAll();
        return clientes;
    }


    //Método que usa repositorio para guardar un cliente en BD
    @Override
    public Cliente creaCliente(@RequestBody Cliente cliente) throws BadRequestException,ConflictException {
              
        Cliente clien= this.clienteRepositorio.save(cliente);

      return clien;
    }


     // Metodo para modificar un cliente en BD
    @Override
    public Cliente cambiarCliente(Long id, Cliente cliente)  throws ConflictException,NotFoundException,BadRequestException {
      
       //Obtiene un cliente en concreto de BD usando su id
       Cliente clien=this.clienteRepositorio.findById(id).get();
       
       //Modifica cada uno de sus atributos con los obtenidos por parametro 
       clien.setCif(cliente.getCif());
       clien.setNombEmp(cliente.getNombEmp());
       clien.setNombre(cliente.getNombre());
       clien.setApellidos(cliente.getApellidos());
       clien.setDni(cliente.getDni());
       clien.setDireccionFiscal(cliente.getDireccionFiscal());
       clien.setComercial(cliente.getComercial());
       clien.setCurso(cliente.getCurso());
       clien.setEspacio(cliente.getEspacio());
       //Se instancia una lista de espacios y se rellena con la del cliente obtenido por parametro
       List<Espacio> espacios=new ArrayList<Espacio>();
       espacios.addAll( cliente.getEspacio());
       //Lo mismo con una lista de lugares
       List<Lugar> lugares=new ArrayList<Lugar>() ;
       //Cada lugar a su vez tiene una lista de espacios 
       for (Espacio espacio : espacios) {
        //Se asignan esas listas obtenidas a las que pertenecen al cliente a persistir
        espacio.setCliente(cliente);
        lugares.addAll(espacio.getLugares());
        for (Lugar lugar: lugares){
           lugar.setEspacio(espacio);
         } 

       }
       //Se procede a persistir
       Cliente updatedCliente=this.clienteRepositorio.save(clien);
       return updatedCliente;
    }





    
    // Metodo para borrar un cliente de BD
    @Override
    public void borrarCliente(Cliente cliente) throws ConflictException,NotFoundException{
       clienteRepositorio.delete(cliente);
       
    }
   



 
    //Método para obtener un cliente determinado según su id
    @Override
    public Optional<Cliente> getCliente(Long id) throws NotFoundException{
        
        return clienteRepositorio.findById(id);
    }

   

     // Metodo para crear un equipo en BD
    public Equipo creaEquipo(Equipo equipo) throws BadRequestException,ConflictException{
       
        return this.equipoRepositorio.save(equipo);
    }



    // Metodo para modificar un equipo en BD 
    public Equipo cambiarEquipo(Long id, Equipo equipo)  throws ConflictException,NotFoundException,BadRequestException {
         
        //Obtiene un equipo en concreto de BD usando su id
         Equipo equip=this.equipoRepositorio.findById(id).get();
          //Modifica cada uno de sus atributos con los obtenidos por parametro
          equip.setNumSerie(equipo.getNumSerie());
          equip.setMarca(equipo.getMarca());
          equip.setModelo(equipo.getModelo());
          equip.setFabricante(equipo.getFabricante());
          equip.setFechaFabricacion(equipo.getFechaFabricacion());
          equip.setFechaCaducidad(equipo.getFechaCaducidad());
          equip.setFechaEntrega(equipo.getFechaEntrega());
          equip.setCodAiviago(equipo.getCodAiviago());
          equip.setPin(equipo.getPin());
          equip.setPuk(equipo.getPuk());
          equip.setOperador(equipo.getOperador());
          equip.setNumtlfnoAiviago(equipo.getNumtlfnoAiviago());
          equip.setNumSerieCabina(equipo.getNumSerieCabina());
          equip.setRefCabina(equipo.getRefCabina());
          equip.setCondicionUsado(equipo.getCondicionUsado());
          equip.setDocUsoCreada(equipo.getDocUsoCreada());
          equip.setSenaletica(equipo.getSenaletica());
          equip.setAsignado(equip.getAsignado());
        //Se persiste y se devuelve
         Equipo updatedEquipo=this.equipoRepositorio.save(equip);
         return updatedEquipo;
    }




    //Metodo para obtener todos los espacios de un cliente determinado elegido por su id
    @Override
    public List<Espacio> getEspaciosdeUnCliente(Long id) throws NotFoundException{
        //Se crea una lista de espacios
        List<Espacio> espacios = new ArrayList<Espacio>();
        //Usando el repositorio se obtiene el cliente por su id
        Cliente cliente= this.clienteRepositorio.findById(id).get();
        //Se llena la lista espacios con las de ese cliente y se devuelve
        espacios.addAll(cliente.getEspacio());
        return espacios;
    }




    //Metodo para obtener todos los cursos de un cliente determinado elegido por su id
    @Override
    public List<Curso> getCursosdeUnCliente(Long id) throws NotFoundException{
        //Se crea una lista de cursos
        List<Curso> cursos = new ArrayList<Curso>();
        //Usando el repositorio se obtiene el cliente por su id
        Cliente cliente= this.clienteRepositorio.findById(id).get();
        //Se llena la lista espacios con las de ese cliente y se devuelve
        cursos.addAll(cliente.getCurso());
        return cursos;
    }




    //Método para saber si un cliente existe
    @Override
    public boolean existsClienteById(Long id) throws NotFoundException{
        return existsClienteById( id);
    }



   


}
