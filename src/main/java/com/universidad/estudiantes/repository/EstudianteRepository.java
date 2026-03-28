package com.universidad.estudiantes.repository;

import com.universidad.estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
