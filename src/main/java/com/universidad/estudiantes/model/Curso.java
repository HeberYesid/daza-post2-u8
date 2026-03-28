package com.universidad.estudiantes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del curso es obligatorio")
    @Column(nullable = false, length = 150)
    private String nombre;

    @Min(value = 1, message = "Los créditos deben ser al menos 1")
    @Column(nullable = false)
    private int creditos;

    @ManyToMany
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    )
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Curso() {
    }

    public Curso(Long id, String nombre, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.getCursos().add(this);
    }

    public void removeEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        estudiante.getCursos().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
