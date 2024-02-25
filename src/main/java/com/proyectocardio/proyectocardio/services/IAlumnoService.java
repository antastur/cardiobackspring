package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectocardio.proyectocardio.models.Alumno;
import com.proyectocardio.proyectocardio.models.Formacion;

@Service
public interface IAlumnoService {

    public List<Alumno> getAlumnos();
    public Alumno creaAlumno(Alumno alumno);
    public Alumno cambiarAlumno(Long id,Alumno alumno);
    public void borrarAlumno(Alumno alumno);
    public Optional<Alumno>  getAlumno(Long id);
    public List<Alumno> findByFormacion(Formacion formacion);
    
}
