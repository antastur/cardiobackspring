package com.proyectocardio.proyectocardio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.proyectocardio.proyectocardio.models.Curso;
import com.proyectocardio.proyectocardio.repositories.CursoRepository;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository cursoRepositorio;

    CursoService() {
    }

    // Metodo para obtener todos los cursos de BD
    @Override
    public List<Curso> getCursos() {

        List<Curso> cursos = this.cursoRepositorio.findAll();
        return cursos;
    }

    // Metodo para crear un curso en BD
    @Override
    public Curso creaCurso(@RequestBody Curso curso) {

        return this.cursoRepositorio.save(curso);
    }

    // Metodo para modificar un curso en BD
    @Override
    public Curso cambiarCurso(Long id, Curso curso) {

        Curso curs = this.cursoRepositorio.findById(id).get();
        curs.setNombre(curs.getNombre());
        curs.setFormaciones(curs.getFormaciones());
        Curso updatedCurso = this.cursoRepositorio.save(curs);
        return updatedCurso;
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
    public Curso getCurso(Long id) {
        // Metodo para encontrar un curso en concreto segun su id
        Optional<Curso> op = this.cursoRepositorio.findById(id);
        Curso cu = null;
        if (op.isPresent()) {
            cu = op.get();
            return cu;
        } else {
            return null;
        }
    }

}
