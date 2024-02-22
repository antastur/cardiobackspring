package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.repositories.AlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepositorio;

    AlumnoService(){}



    
    @Override
    public List<Alumno> getAlumnos() {
        // Metodo para obtener todos los alumnos de BD
        List<Alumno> alumnos=this.alumnoRepositorio.findAll();
        return alumnos;
    }

    @Override
    public Alumno creaAlumno(@RequestBody Alumno alumno) {
        // Metodo para crear un alumno en BD
        return this.alumnoRepositorio.save(alumno);
    }



    @Override
    public Alumno cambiarAlumno(Long id, Alumno alumno) {
        // Metodo para modificar un alumno en BD
        Alumno alum=this.alumnoRepositorio.findById(id).get();
        alum.setNombre(alumno.getNombre());
        alum.setApellidos(alumno.getApellidos());
        alum.setDniAlumno(alumno.getDniAlumno());

        Alumno updatedAlumno=this.alumnoRepositorio.save(alum);
        return updatedAlumno;

      
    }


    @Override
    public Boolean borrarAlumno(Long id) {
        // Metodo para eliminar un alumno de BD
        Alumno alumno;
        Boolean borrado=true;
        Optional<Alumno> oal=this.alumnoRepositorio.findById(id);
        if(oal.isPresent())
        try{
            alumno=oal.get();
            this.alumnoRepositorio.delete(alumno);
    
        }catch(Exception e){
            borrado=false;
        }
        return borrado;
    }

    @Override
    public Alumno getAlumno(Long id) {
        // Metodo para encontrar un alumno en concreto segun su id
        Optional <Alumno> op= this.alumnoRepositorio.findById(id);
         Alumno al=null;
            if(op.isPresent()){
                al=op.get();
                return al;
            }else{
                return null;
            }
    }




    @Override
    public List<Alumno> findByFormacion(Formacion formacion) {
      return null;
    }



}
