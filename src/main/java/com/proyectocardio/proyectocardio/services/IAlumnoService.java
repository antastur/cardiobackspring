package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Formacion;

@Service
public interface IAlumnoService {

    public List<Alumno> getAlumnos();
    public Alumno creaAlumno(Alumno alumno);
    public Alumno cambiarAlumno(Long id,Alumno alumno);
    public Boolean borrarAlumno(Long id);
    public Alumno  getAlumno(Long id);
    public List<Alumno> findByFormacion(Formacion formacion);
    
}
