package com.foro.hub.forohub.controller;

import com.foro.hub.forohub.Dto.DatosRegistroRespuesta;
import com.foro.hub.forohub.Dto.DatosRespuestaRespuesta;
import com.foro.hub.forohub.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
    private final RespuestaService service;

    public RespuestaController(RespuestaService service) {
        this.service = service;
    }

    @PostMapping
    public DatosRespuestaRespuesta crear(@RequestBody @Valid DatosRegistroRespuesta datos) {
        return service.crear(datos);
    }

    @GetMapping
    public List<DatosRespuestaRespuesta> listar() {
        return service.listar();
    }
}

