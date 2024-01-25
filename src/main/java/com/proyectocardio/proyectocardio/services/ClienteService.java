package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.repositories.ClienteRepository;

@Service
public class ClienteService implements IClienteService{


    @Autowired
    private ClienteRepository clienteRepositorio;

    ClienteService(){}



    @Override
    public List<Cliente> getClientes() {
       // Metodo para obtener todos los alumnos de BD
        List<Cliente> alumnos=this.clienteRepositorio.findAll();
        return alumnos;
    }

    @Override
    public Cliente creaCliente(@RequestBody Cliente cliente) {
      // Metodo para crear un alumno en BD
      return this.clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente cambiarCliente(Long id, Cliente cliente) {
       // Metodo para modificar un alumno en BD
       Cliente clien=this.clienteRepositorio.findById(id).get();
       clien.setCif(clien.getCif());
       clien.setNombEmp(clien.getNombEmp());
       clien.setNombre(clien.getNombre());
       clien.setApellidos(clien.getApellidos());
       clien.setDni(clien.getDni());
       clien.setDireccionFiscal(clien.getDireccionFiscal());

       clien.setComercial(clien.getComercial());
       clien.setCurso(clien.getCurso());
       clien.setEspacio(clien.getEspacio());

       Cliente updatedCliente=this.clienteRepositorio.save(clien);
       return updatedCliente;
    }

    @Override
    public Boolean borrarCliente(Long id) {
       // Metodo para eliminar un alumno de BD
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

    @Override
    public Cliente getCliente(Long id) {
        // Metodo para encontrar un alumno en concreto segun su id
        Optional < Cliente> op= this.clienteRepositorio.findById(id);
        Cliente cl=null;
            if(op.isPresent()){
                cl=op.get();
                return cl;
            }else{
                return null;
            }
    }

}
