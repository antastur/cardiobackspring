package com.proyectocardio.proyectocardio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.CursoDto;

@Service
public interface ICursoService {

     public List<CursoDto> getCursos();
    public CursoDto creaCurso(Curso curso);
    public CursoDto cambiarCurso(Long id,Curso curso);
    public Boolean borrarCurso(Long id);
    public CursoDto  getCurso(Long id);
}
