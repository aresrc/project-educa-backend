package com.educatoon.intranet.controllers;

import com.educatoon.intranet.models.Seccion;
import com.educatoon.intranet.models.PerfilEstudiante;
import com.educatoon.intranet.services.SeccionService;
import com.educatoon.intranet.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/secciones")
public class SeccionController {
    private final SeccionService seccionService;
    private final EstudianteService estudianteService;

    @Autowired
    public SeccionController(SeccionService seccionService, EstudianteService estudianteService) {
        this.seccionService = seccionService;
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Seccion> getAllSecciones() {
        return seccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seccion> getSeccionById(@PathVariable Long id) {
        Seccion seccion = seccionService.findById(id);
        if (seccion != null) {
            return ResponseEntity.ok(seccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Seccion createSeccion(@RequestBody Seccion seccion) {
        return seccionService.save(seccion);
    }

    @PostMapping("/{seccionId}/matricular/{codigoEstudiante}")
    public ResponseEntity<?> matricularEstudiante(
            @PathVariable Long seccionId,
            @PathVariable String codigoEstudiante) {
        PerfilEstudiante estudiante = estudianteService.findByCodigoEstudiante(codigoEstudiante);
        if (estudiante == null) {
            return ResponseEntity.badRequest().body("Estudiante no encontrado");
        }

        seccionService.matricularEstudiante(seccionId, estudiante);
        return ResponseEntity.ok().build();
    }
}
