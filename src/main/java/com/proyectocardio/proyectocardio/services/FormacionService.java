package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.FormacionDto;
import com.proyectocardio.proyectocardio.repositories.FormacionRepository;

@Service
public class FormacionService implements IformacionService {

     @Autowired
    private FormacionRepository formacionRepositorio;

    FormacionService(){}

    @Override
    public List<FormacionDto> getFormacion() {
        //Metodo para obtener todos los eformaciones de BD
        
          throw new UnsupportedOperationException("Unimplemented method 'getFormacion'");
    }

    @Override
    public Formacion creaFormacion(Formacion formacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creaFormacion'");
    }

    @Override
    public Formacion cambiarFormacion(Long id, Formacion formacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarFormacion'");
    }

    @Override
    public void borrarFormacion(Formacion formacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarFormacion'");
    }

    @Override
    public Optional<Formacion> getFormacion(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormacion'");
    }

    @Override
    public List<Formacion> findByFormacion(Formacion formacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByFormacion'");
    }

//     @Override
//     public List<Formacion> getFormaciones() {
//        // Metodo para obtener todos los eformaciones de BD
//         List<Formacion> formaciones=this.formacionRepositorio.findAll();
//         return formaciones;
//     }

//     @Override
//     public Formacion creaFormacion(Formacion formacion) {
//         // Metodo para crear un equipo en BD
//         return this.formacionRepositorio.save(formacion);
//     }

//     @Override
//     public Formacion cambiarFormacion(Long id, Formacion formacion) {
//        return null;
//     }

//     @Override
//     public Boolean borrarFormacion(Long id) {
//         // Metodo para eliminar un equipo de BD
//         Formacion formacion;
//         Boolean borrado=true;
//         Optional<Formacion> oform=this.formacionRepositorio.findById(id);
//     if(oform.isPresent())
//     try{
//         formacion=oform.get();
       
//         //Se borra el objeto de BD
//        this.formacionRepositorio.delete(formacion);

//     }catch(Exception e){
//         borrado=false;
//     }
//     return borrado;
//     }

//     @Override
//     public Formacion getFormacion(Long id) {
//       // Metodo para obtener un equipo determinado según su id
//       Optional <Formacion> oForm= this.formacionRepositorio.findById(id);
//       Formacion formacion=null;
//          if(oForm.isPresent()){
//              formacion=oForm.get();
//              return formacion ;
//          }else{
//              return null;
//          }

//  }

}
