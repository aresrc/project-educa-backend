package com.educatoon.intranet.controllers;


import com.educatoon.intranet.dto.PerfilDTO;
import com.educatoon.intranet.models.Perfil;
import com.educatoon.intranet.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> obtenerDatosUsuarios(@PathVariable Long id) {
        Perfil respuesta = perfilService.findById(id);
        PerfilDTO dto = new PerfilDTO();
        dto.setDni(respuesta.getDni());
        dto.setNombre(respuesta.getNombre());
        dto.setFechaNacimiento(respuesta.getFechaNacimiento());
        dto.setGenero(respuesta.getGenero());
        dto.setTelefono(respuesta.getTelefono());
        dto.setCorreo(respuesta.getCorreo());
        dto.setTipoPerfil("ESTUDIANTE");
        return ResponseEntity.ok(dto);
    }
}
