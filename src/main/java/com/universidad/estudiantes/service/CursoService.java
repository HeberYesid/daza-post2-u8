package com.universidad.estudiantes.service;

import com.universidad.estudiantes.model.Curso;
import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.repository.CursoRepository;
import com.universidad.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;

    public CursoService(CursoRepository cursoRepository, EstudianteRepository estudianteRepository) {
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional(readOnly = true)
    public List<Curso> listarConEstudiantes() {
        return cursoRepository.findAllConEstudiantes();
    }

    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Transactional
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void inscribir(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow();
        curso.addEstudiante(estudiante);
        cursoRepository.save(curso);
    }
}
