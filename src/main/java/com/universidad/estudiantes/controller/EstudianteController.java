package com.universidad.estudiantes.controller;

import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", service.listar());
        return "estudiantes/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Estudiante estudiante = service.buscarPorId(id).orElse(new Estudiante());
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("estudiante", estudiante);
            return "estudiantes/formulario";
        }
        service.guardar(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String confirmarEliminar(@PathVariable Long id, Model model) {
        Estudiante estudiante = service.buscarPorId(id).orElse(new Estudiante());
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/confirmar-eliminar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/estudiantes";
    }
}
