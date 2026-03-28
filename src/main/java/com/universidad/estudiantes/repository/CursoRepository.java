package com.universidad.estudiantes.repository;

import com.universidad.estudiantes.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT DISTINCT c FROM Curso c LEFT JOIN FETCH c.estudiantes")
    List<Curso> findAllConEstudiantes();
}
