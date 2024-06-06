package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.models.FormacionDto;
import com.proyectocardio.proyectocardio.repositories.CursoRepository;
import com.proyectocardio.proyectocardio.repositories.FormacionRepository;

@Service
public class FormacionService implements IformacionService {

    @Autowired
    private FormacionRepository formacionRepositorio;

    @Autowired
    private CursoRepository cursoRepository;

    ModelMapper modelMapper=new ModelMapper();
    
    FormacionService(){

    }

    @Override
    public List<FormacionDto> getFormacion() {
        //Metodo para obtener todos los eformaciones de BD
        List<Formacion> formaciones=formacionRepositorio.findAll();
        
        List<FormacionDto> formacionesDto = formaciones.stream().map(formacion-> modelMapper.map(formacion, FormacionDto.class)).collect(Collectors.toList());
        
          return formacionesDto;
    }

    @Override
    public FormacionDto creaFormacion(Formacion formacion) {
       FormacionDto formacionDto= modelMapper.map(formacion, FormacionDto.class);
       formacionRepositorio.save(formacion);

    return formacionDto;
    }

    @Override
    public FormacionDto cambiarFormacion(Long id, Formacion formacion) {
        Optional<Formacion> form=formacionRepositorio.findById(id);
        
            if(form.isPresent()){

               form.get().setTipo(formacion.getTipo()); 
               form.get().setSenaletica(formacion.isSenaletica());
               form.get().setNumAsistentes(formacion.getNumAsistentes());
               form.get().setImpartidor(formacion.getImpartidor());
               form.get().setEstado(formacion.isEstado());
               form.get().setDiplomas(formacion.getDiplomas());
               form.get().setDateFormacion(formacion.getDateFormacion());
               form.get().setRecuerdo(formacion.getRecuerdo());
               if(form.get().getDateFormacion().isAfter(form.get().getRecuerdo()) | form.get().getDateFormacion().equals(form.get().getRecuerdo())){
                throw new ConflictException("Error en las fechas");
               }
               form.get().setCurso(formacion.getCurso());
               form.get().setAlumnos(formacion.getAlumnos());
            }else{
                throw new NotFoundException("No existe formacion con id "+id);
            }
        
            FormacionDto formacionDto= modelMapper.map(form.get(),FormacionDto.class);
        
        return formacionDto;

    }

    @Override
    public void borrarFormacion(Formacion formacion) {
        formacionRepositorio.delete(formacion);
    }

    @Override
    public FormacionDto  getFormacion(Long id) {
        
        Optional<Formacion> form=formacionRepositorio.findById(id);

        if(form.isPresent()){
            FormacionDto formacionDto= modelMapper.map(form.get(),FormacionDto.class);
            return formacionDto;
        }else{
            throw new NotFoundException("No existe formacion con id "+id);
        }
      
    }

    @Override
    public List<FormacionDto> getFormacionesByCurso(Long id) {
        Optional<Curso> curso= cursoRepository.findById(id);
        if(curso.isPresent()){
            List<Formacion> formaciones= formacionRepositorio.findByCurso(curso.get());
            List<FormacionDto> formacionesDto=formaciones.stream().map(formacion->modelMapper.map(formacion, FormacionDto.class)).collect(Collectors.toList());
            return formacionesDto;
        }else{
            throw new UnsupportedOperationException("Unimplemented method 'getFormacionesByCurso'");

        }
        

      
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
