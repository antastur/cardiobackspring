package com.proyectocardio.proyectocardio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.models.Espacio;
import com.proyectocardio.proyectocardio.models.Lugar;
import com.proyectocardio.proyectocardio.repositories.ClienteRepository;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;
import com.proyectocardio.proyectocardio.repositories.EspacioRepository;
import com.proyectocardio.proyectocardio.repositories.LugarRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService implements IClienteService{


    @Autowired
    private ClienteRepository clienteRepositorio;
    private EspacioRepository espacioRepositorio;
    private LugarRepository lugarRepositorio;
    private EquipoRepository equipoRepositorio;
    
    
    ClienteService(){}


    
    @Override
    public List<Cliente> getClientes() {
       // Metodo para obtener todos los clientes de BD
        List<Cliente> clientes=this.clienteRepositorio.findAll();
        return clientes;
    }


    
    @Override
    public Cliente creaCliente(@RequestBody Cliente cliente) {
      // Metodo para crear un cliente en BD
      return this.clienteRepositorio.save(cliente);
    }


   
    @Override
    public Cliente cambiarCliente(Long id, Cliente cliente) {
       // Metodo para modificar un cliente en BD
       
       Cliente clien=this.clienteRepositorio.findById(id).get();
       
       clien.setCif(cliente.getCif());
       clien.setNombEmp(cliente.getNombEmp());
       clien.setNombre(cliente.getNombre());
       clien.setApellidos(cliente.getApellidos());
       clien.setDni(cliente.getDni());
       clien.setDireccionFiscal(cliente.getDireccionFiscal());

       clien.setComercial(cliente.getComercial());
       clien.setCurso(cliente.getCurso());
       clien.setEspacio(cliente.getEspacio());

       List<Espacio> espacios=new ArrayList<Espacio>();
       espacios.addAll( cliente.getEspacio());
       List<Lugar> lugares=new ArrayList<Lugar>() ;
       
       for (Espacio espacio : espacios) {
        
        espacio.setCliente(cliente);
        lugares.addAll(espacio.getLugares());
        for (Lugar lugar: lugares){
           lugar.setEspacio(espacio);
         } 

       }
      
       Cliente updatedCliente=this.clienteRepositorio.save(clien);
       return updatedCliente;
    }


    @Override
    public void borrarCliente(Cliente cliente) {
       clienteRepositorio.delete(cliente);
       
    }
   
  /*  @Override
    public Boolean borrarCliente(Long id) {
       // Metodo para eliminar un cliente de BD
        Cliente cliente;
        Boolean borrado=true;
        Optional<Cliente> ocl=this.clienteRepositorio.findById(id);
        if(ocl.isPresent())
        try{
            cliente=ocl.get();
            this.clienteRepositorio.delete(cliente);
    
        }catch(Exception e){
            borrado=false;
        }
        return borrado;
    }

*/ 
    
    @Override
    public Cliente getCliente(Long id) {
        // Metodo para encontrar un alumno en concreto segun su id
        return clienteRepositorio.findById(id).orElse(null);
    }

   

    
    public Equipo creaEquipo(Equipo equipo) {
        // Metodo para crear un equipo en BD
        return this.equipoRepositorio.save(equipo);
    }



   
    public Equipo cambiarEquipo(Long id, Equipo equipo) {
         // Metodo para modificar un equipo en BD
         Equipo equip=this.equipoRepositorio.findById(id).get();
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
        
         Equipo updatedEquipo=this.equipoRepositorio.save(equip);
         return updatedEquipo;
    }


   
    @Override
    public List<Espacio> getEspaciosdeUnCliente(Long id) {
        
        List<Espacio> espacios = new ArrayList<Espacio>();
        Cliente cliente= this.clienteRepositorio.findById(id).get();
        espacios.addAll(cliente.getEspacio());
        return espacios;
    }



   
    @Override
    public List<Curso> getCursosdeUnCliente(Long id) {
        
        List<Curso> cursos = new ArrayList<Curso>();
        Cliente cliente= this.clienteRepositorio.findById(id).get();
        cursos.addAll(cliente.getCurso());
        return cursos;
    }



    @Override
    public boolean existsClienteById(Long id) {
        return existsClienteById( id);
    }



   


}
