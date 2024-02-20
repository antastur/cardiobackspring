package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Cliente;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Espacio;


@Service
public interface IClienteService {

    public List<Cliente> getClientes();
    public Cliente creaCliente(Cliente cliente);
    public Cliente cambiarCliente(Long id,Cliente cliente);
    public void borrarCliente(Cliente cliente);
    public Cliente  getCliente(Long id);
    public List<Espacio> getEspaciosdeUnCliente(Long id);
    public List<Curso> getCursosdeUnCliente(Long id);
    boolean existsClienteById(Long id);
}
