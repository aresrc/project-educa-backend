package com.educatoon.intranet.controllers;

import com.educatoon.intranet.models.PerfilEstudiante;
import com.educatoon.intranet.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<PerfilEstudiante> getAllEstudiantes() {
        return estudianteService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PerfilEstudiante> getEstudianteByCodigo(@PathVariable String codigo) {
        PerfilEstudiante estudiante = estudianteService.findByCodigoEstudiante(codigo);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PerfilEstudiante createEstudiante(@RequestBody PerfilEstudiante estudiante) {
        return estudianteService.save(estudiante);
    }
}
