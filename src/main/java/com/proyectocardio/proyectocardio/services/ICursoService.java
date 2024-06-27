package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.CursoDto;

@Service
public interface ICursoService {

     public List<CursoDto> getCursos();
    public Curso creaCurso(Curso curso);
    public Curso cambiarCurso(Long id,Curso curso);
    public Boolean borrarCurso(Long id);
    public Optional <Curso>  getCurso(Long id);
}
