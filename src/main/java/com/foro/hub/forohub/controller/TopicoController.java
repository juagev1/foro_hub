package com.foro.hub.forohub.controller;


import com.foro.hub.forohub.Dto.*;
import com.foro.hub.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public DatosRespuestaTopico crear(@RequestBody @Valid DatosRegistroTopico datos) {
        return service.crear(datos);
    }

    @GetMapping
    public List<DatosRespuestaTopico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DatosRespuestaTopico obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public DatosRespuestaTopico actualizar(@PathVariable Long id, @RequestBody DatosActualizarTopico datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
