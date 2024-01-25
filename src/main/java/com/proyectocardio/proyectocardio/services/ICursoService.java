package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Curso;

@Service
public interface ICursoService {

     public List<Curso> getCursos();
    public Curso creaCurso(Curso curso);
    public Curso cambiarCurso(Long id,Curso curso);
    public Boolean borrarCurso(Long id);
    public Curso  getCurso(Long id);
}
