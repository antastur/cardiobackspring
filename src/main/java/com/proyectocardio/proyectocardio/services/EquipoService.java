package com.proyectocardio.proyectocardio.services;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;


@Service
public class EquipoService implements IEquipoService{

    LocalDate localDate;

    @Autowired
    private EquipoRepository equipoRepositorio;

    //Constructor inyectando la fecha actual
    EquipoService(){
        this.localDate=LocalDate.now();
    }
   

    // Metodo para obtener todos los equipos de BD
    @Override
    public List<Equipo> getEquipos() {
        List<Equipo> equipos=this.equipoRepositorio.findAllByOrderByIdAsc();
        return equipos;
    }


     // Metodo para crear un equipo en BD.
    @Override
    public Equipo creaEquipo(Equipo equipo) {

        if(equipo.getNumtlfnoAiviago()!=null){

        if(!equipo.getNumtlfnoAiviago().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}
        }
            
        //Si la fecha de entrega es anterior a fecha de fabricacion da error
        if(equipo.getFechaEntrega().isBefore(equipo.getFechaFabricacion())){
            throw new ConflictException("Error al introducir Fecha de entrega o fabricación");
        }
        //Si la fecha de caducidad es anterior a fecha de entrega da error
        if(equipo.getFechaCaducidad().isBefore(equipo.getFechaEntrega())){
            throw new ConflictException("Error al introducir Fecha de entrega o caducidad");
        }
         if(equipo.getFechaCaducidad().isBefore(equipo.getFechaEntrega()))
         {
            throw new ConflictException("Error al introducir Fecha de fabricación o caducidad");
        }

       
        //Se establece fecha mantenimiento 1 año despues de fecha de entrega
        equipo.setFechaMantenimiento(equipo.getFechaEntrega().plusYears(1)); 


        if(equipo.getFechaCaducidad().isBefore(equipo.getFechaMantenimiento()))
        {
           throw new ConflictException("Error al introducir Fecha de fabricación o caducidad");
       }

        
        if (equipo.getFechaMantenimiento().isBefore(LocalDate.now())){

            equipo.setFechaMantenimiento(LocalDate.now());
            
            equipo=this.equipoRepositorio.save(equipo);
            return equipo;
        }else{
        equipo=this.equipoRepositorio.save(equipo);
        return equipo;}
    }



     // Metodo para modificar un equipo en BD
    @Override
    public Equipo cambiarEquipo(Long id, Equipo equipo) {

        if(equipo.getNumtlfnoAiviago()!=null){
        if(!equipo.getNumtlfnoAiviago().matches("\\d{9}")){
            throw new ConflictException("Error al introducir el teléfono");}
        }
        //Si la fecha de mantenimiento introducida es anterior a la fecha fabricación
        
        //Si la fecha de entrega es anterior a fecha de fabricacion da error
        if(equipo.getFechaEntrega().isBefore(equipo.getFechaFabricacion())){
            throw new ConflictException("Error al introducir Fecha de entrega o fabricación");
        }
        //Si la fecha de caducidad es anterior a fecha de entrega da error
        if(equipo.getFechaCaducidad().isBefore(equipo.getFechaEntrega())){
            throw new ConflictException("Error al introducir Fecha de entrega o caducidad");
        }    //Si la fecha de mantenimiento es anterior al dia actual se establece día actual como fecha mantenimiento
       
        if(equipo.getFechaCaducidad().isBefore(equipo.getFechaEntrega()))
        {
           throw new ConflictException("Error al introducir Fecha de fabricación o caducidad");
       }
       
       if(equipo.getFechaCaducidad().isBefore(equipo.getFechaMantenimiento()))
       {
          throw new ConflictException("Error al introducir Fecha de fabricación o caducidad");
      }

        //Se establece fecha mantenimiento 1 año despues de fecha de entrega
        //equipo.setFechaMantenimiento(equipo.getFechaEntrega().plusYears(1)); 
                
        if (equipo.getFechaMantenimiento().isBefore(LocalDate.now())){

          equipo.setFechaMantenimiento(LocalDate.now());
        }
        
          Equipo equip=this.equipoRepositorio.findById(id).get();
          equip.setNumSerie(equipo.getNumSerie());
          equip.setMarca(equipo.getMarca());
          equip.setModelo(equipo.getModelo());
          equip.setFabricante(equipo.getFabricante());
          equip.setFechaFabricacion(equipo.getFechaFabricacion());
          equip.setFechaCaducidad(equipo.getFechaCaducidad());
         
          if(equip.getFechaEntrega().equals(equipo.getFechaEntrega())){
            
                equip.setFechaMantenimiento(equipo.getFechaMantenimiento());
                equip.setFechaEntrega(equipo.getFechaEntrega()); 
            }else{
                equip.setFechaMantenimiento(equipo.getFechaEntrega().plusYears(1));
                equip.setFechaEntrega(equipo.getFechaEntrega()); 
            }

        if (equipo.getFechaMantenimiento().isBefore(equipo.getFechaEntrega())){
            throw new ConflictException("Error al introducir Fecha de mantenimiento");
        }
          
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
          equip.setAsignado(equipo.getAsignado());
        
         Equipo updatedEquipo=this.equipoRepositorio.save(equip);
         return updatedEquipo;
    }


    // Metodo para eliminar un equipo de BD
    @Override
    public Boolean borrarEquipo(Long id) {
        
        Equipo equip=null;
        Boolean borrado=true;
        Optional<Equipo> oequip=this.equipoRepositorio.findById(id);
    if(oequip.isPresent())
    try{
        equip=oequip.get();  }catch(Exception e){
            borrado=false;
        }
        if(equip.getAsignado()==true){
            throw new ConflictException("Equipo asignado");
            }
           
     //Se borra el objeto de BD
      else{
        this.equipoRepositorio.delete(equip);
        
       }

  
    return borrado;
    }



    // Metodo para obtener un equipo determinado según su id
    @Override
    public Equipo getEquipo(Long id) {
        
        Optional <Equipo> oEquip= this.equipoRepositorio.findById(id);
         Equipo equipo=null;
            if(oEquip.isPresent()){
                equipo=oEquip.get();
                return equipo;
            }else{
                return null;
            }
 }



    //Metodo  para obtener los equipos disponibles(no asignados)
    @Override
    public List<Equipo> getEquiposNoAsignados(Boolean asignado) {
       List<Equipo> equipos= this.equipoRepositorio.findByAsignado(false);
       return equipos;
    }


    //Metodo para buscar los equipos de exterior (los que contienen en su ref cabina la palabra 'exterior')
    @Override
    public List<Equipo> findByRefCabina(Boolean asignado) {
        List<Equipo> equipos=  this.equipoRepositorio.findByRefCabina("exterior");
        return equipos;
    }


    //Metodo para buscar los equipos que esten usados (condicionUsado=true)
    @Override
    public List<Equipo> findByCondicionUsado(Boolean asignado) {
        List<Equipo> equipos=  this.equipoRepositorio.findByCondicionUsado(true);
        return equipos;
    }


    //Metodo para buscar los equipos que caduquen antes de un año (los de fecha caducidad anterior a la fecha actual + 1 año)
    @Override
    public List<Equipo> findByFechaCaducidad(LocalDate fechaCaducidad) {
        List<Equipo> equipos= this.equipoRepositorio.findByFechaCaducidadBefore(this.localDate.plusYears(1));
        return equipos;
    }


    @Override
    public List<Equipo> findByFechaMantenimiento(LocalDate fechaMantenimiento) {
        List<Equipo> equipos= this.equipoRepositorio.findByFechaMantenimientoBefore(this.localDate.plusMonths(2));
        
      

        
        return equipos;
    }
     
    }

    
 /*   @Override
    public List<Equipo> findByFechaCaducidad(LocalDate localDate) {
        return this.findByFechaCaducidad(LocalDate.now().plusYears(1));
    }  */
    







