package com.universidad.estudiantes.controller;

import com.universidad.estudiantes.model.Curso;
import com.universidad.estudiantes.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", service.listarConEstudiantes());
        return "cursos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("curso", curso);
            return "cursos/formulario";
        }
        service.guardar(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/inscripciones")
    public String inscripciones(Model model) {
        model.addAttribute("cursos", service.listarCursos());
        model.addAttribute("estudiantes", service.listarEstudiantes());
        return "cursos/inscripcion";
    }

    @PostMapping("/inscripciones")
    public String inscribir(@RequestParam Long cursoId, @RequestParam Long estudianteId) {
        service.inscribir(cursoId, estudianteId);
        return "redirect:/cursos";
    }
}
