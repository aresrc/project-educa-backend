package com.educatoon.intranet.controllers;

import com.educatoon.intranet.dto.RegistroUsuarioDTO;
import com.educatoon.intranet.services.RegistroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/actualizar/{correo}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable String correo, @RequestBody RegistroUsuarioDTO dto) {
        boolean actualizado = registroUsuarioService.actualizarUsuario(correo,dto);
        if (actualizado) {
            return ResponseEntity.ok("Usuario actualizado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }

    @DeleteMapping("/eliminar/{correo}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String correo) {
        boolean eliminado = registroUsuarioService.eliminarUsuario(correo);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }

}

