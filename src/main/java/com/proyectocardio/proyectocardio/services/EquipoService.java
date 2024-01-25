package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Equipo;
import com.proyectocardio.proyectocardio.repositories.EquipoRepository;

@Service
public class EquipoService implements IEquipoService{


    @Autowired
    private EquipoRepository equipoRepositorio;

    EquipoService(){}
   
    @Override
    public List<Equipo> getEquipos() {
        // Metodo para obtener todos los alumnos de BD
        List<Equipo> equipos=this.equipoRepositorio.findAll();
        return equipos;
    }

    @Override
    public Equipo creaEquipo(Equipo equipo) {
        // Metodo para crear un alumno en BD
        return this.equipoRepositorio.save(equipo);
    }

    @Override
    public Equipo cambiarEquipo(Long id, Equipo equipo) {
         // Metodo para modificar un alumno en BD
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
        
         Equipo updatedEquipo=this.equipoRepositorio.save(equip);
         return updatedEquipo;
    }

    @Override
    public Boolean borrarEquipo(Long id) {
        // Metodo para eliminar un equipo de BD
        Equipo equip;
        Boolean borrado=true;
        Optional<Equipo> oequip=this.equipoRepositorio.findById(id);
    if(oequip.isPresent())
    try{
        equip=oequip.get();
       
        //Se borra el objeto de BD
       this.equipoRepositorio.delete(equip);

    }catch(Exception e){
        borrado=false;
    }
    return borrado;
    }


    @Override
    public Equipo getEquipo(Long id) {
        // Metodo para obtener un equipo determinado según su id
        Optional <Equipo> oEquip= this.equipoRepositorio.findById(id);
         Equipo equipo=null;
            if(oEquip.isPresent()){
                equipo=oEquip.get();
                return equipo;
            }else{
                return null;
            }

    }



}
