package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.exceptiones.ConflictException;
import com.proyectocardio.proyectocardio.exceptiones.NotFoundException;
import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Formacion;
import com.proyectocardio.proyectocardio.repositories.AlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepositorio;

    AlumnoService(){}



    // Metodo para obtener todos los alumnos de BD
    @Override
    public List<Alumno> getAlumnos() {
        
        List<Alumno> alumnos=this.alumnoRepositorio.findAll();
        return alumnos;
    }


     // Metodo para crear un alumno en BD
    @Override
    public Alumno creaAlumno(@RequestBody Alumno alumno) {
       
        return this.alumnoRepositorio.save(alumno);
    }




    // Metodo para modificar un alumno en BD
    @Override
    public Alumno cambiarAlumno(Long id, Alumno alumno) {
        
        Alumno alum=this.alumnoRepositorio.findById(id).get();
        alum.setNombre(alumno.getNombre());
        alum.setApellidos(alumno.getApellidos());
        alum.setDniAlumno(alumno.getDniAlumno());

        Alumno updatedAlumno=this.alumnoRepositorio.save(alum);
        return updatedAlumno;

      
    }

    //Metodo para borrar un alumno
    @Override
    public void borrarAlumno(Alumno alumno) throws ConflictException,NotFoundException{
       alumnoRepositorio.delete(alumno);
       
    }
   

    //Metodo para obtener un alumno por su id
    @Override
    public Optional<Alumno> getAlumno(Long id) throws NotFoundException{
        
        return alumnoRepositorio.findById(id);
    }

   


    //Metodo para obtener los alumnos de una formación
    @Override
    public List<Alumno> findByFormacion(Formacion formacion) {
      return null;
    }



}
