package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.models.CursoDto;
import com.proyectocardio.proyectocardio.repositories.CursoRepository;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository cursoRepositorio;

     ModelMapper modelMapper=new ModelMapper();

    CursoService() {
    }

    // Metodo para obtener todos los cursos de BD
    @Override
    public List<CursoDto> getCursos() {

        List<Curso> cursos = this.cursoRepositorio.findAll();
        List<CursoDto> cursosDto=cursos.stream().map(curso-> modelMapper.map(curso, CursoDto.class)).collect(Collectors.toList());
        return cursosDto;
    }

    // Metodo para crear un curso en BD
    @Override
    public CursoDto creaCurso(@RequestBody Curso curso) {
        this.cursoRepositorio.save(curso);
        CursoDto cursoDto=modelMapper.map(curso,CursoDto.class);

        return cursoDto;
    }

    // Metodo para modificar un curso en BD
    @Override
    public CursoDto cambiarCurso(Long id, Curso curso) {

        Curso curs = this.cursoRepositorio.findById(id).get();
        curs.setNombre(curso.getNombre());
        curs.setFormaciones(curso.getFormaciones());
        this.cursoRepositorio.save(curs);
        CursoDto cursoDto=modelMapper.map(curs, CursoDto.class);
        return cursoDto;
    }

    // Metodo para eliminar un curso de BD
    @Override
    public Boolean borrarCurso(Long id) {

        Curso curso;
        Boolean borrado = true;
        Optional<Curso> ocu = this.cursoRepositorio.findById(id);
        if (ocu.isPresent())
            try {
                curso = ocu.get();
                this.cursoRepositorio.delete(curso);

            } catch (Exception e) {
                borrado = false;
            }
        return borrado;
    }

    @Override
    public CursoDto getCurso(Long id) {
        // Metodo para encontrar un curso en concreto segun su id
        Optional<Curso> op = this.cursoRepositorio.findById(id);
        Curso cu = null;
        if (op.isPresent()) {
            cu = op.get();
            CursoDto cursoDto=modelMapper.map(cu, CursoDto.class);
            return cursoDto;
        } else {
            return null;
        }
    }

}
