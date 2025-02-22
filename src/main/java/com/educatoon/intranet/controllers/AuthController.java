package com.educatoon.intranet.controllers;

import com.educatoon.intranet.models.Credenciales;
import com.educatoon.intranet.repositories.CredencialesRepository;
import com.educatoon.intranet.config.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CredencialesRepository credencialesRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(CredencialesRepository credencialesRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.credencialesRepository = credencialesRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credenciales request) {
        Credenciales credenciales = credencialesRepository.findByCorreo(request.getCorreo());

        if (credenciales != null && passwordEncoder.matches(request.getContrasenia(), credenciales.getContrasenia())) {
            String token = jwtUtil.generateToken(credenciales.getCorreo());
            return ResponseEntity.ok(new AuthResponse(token));
        }

        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }


    static class AuthResponse {
        public String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }
}
