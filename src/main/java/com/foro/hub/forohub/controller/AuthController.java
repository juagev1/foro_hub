package com.foro.hub.forohub.controller;

import com.foro.hub.forohub.security.JwtTokenForoHub;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtTokenForoHub jwtService;

    public AuthController(AuthenticationManager authManager, JwtTokenForoHub jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid com.foro.hub.forohub.controller.DatosLogin datos) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(datos.email(), datos.password())
        );
        return jwtService.generarToken(datos.email());
    }
}

