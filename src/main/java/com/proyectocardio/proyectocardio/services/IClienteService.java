package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Cliente;


@Service
public interface IClienteService {

    public List<Cliente> getClientes();
    public Cliente creaCliente(Cliente cliente);
    public Cliente cambiarCliente(Long id,Cliente cliente);
    public Boolean borrarCliente(Long id);
    public Cliente  getCliente(Long id);
}
