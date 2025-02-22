package com.educatoon.intranet.controllers;

import com.educatoon.intranet.dto.RegistroUsuarioDTO;
import com.educatoon.intranet.services.RegistroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class RegistroUsuarioController {

    @Autowired
    private RegistroUsuarioService registroUsuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody RegistroUsuarioDTO dto) {
        String respuesta = registroUsuarioService.registrarUsuario(dto);
        return ResponseEntity.ok(respuesta);
    }
}

