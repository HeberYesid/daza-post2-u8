package com.universidad.estudiantes.service;

import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Estudiante> listar() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Estudiante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
