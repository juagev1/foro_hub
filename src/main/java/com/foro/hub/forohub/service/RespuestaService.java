package com.foro.hub.forohub.service;

import com.foro.hub.forohub.Dto.*;
import com.foro.hub.forohub.model.Respuesta;
import com.foro.hub.forohub.model.Usuario;
import com.foro.hub.forohub.model.Topico;
import com.foro.hub.forohub.repository.RespuestaRepository;
import com.foro.hub.forohub.repository.UsuarioRepository;
import com.foro.hub.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {
    private final RespuestaRepository repository;
    private final UsuarioRepository usuarioRepo;
    private final TopicoRepository topicoRepo;

    public RespuestaService(RespuestaRepository repository, UsuarioRepository usuarioRepo, TopicoRepository topicoRepo) {
        this.repository = repository;
        this.usuarioRepo = usuarioRepo;
        this.topicoRepo = topicoRepo;
    }

    public DatosRespuestaRespuesta crear(DatosRegistroRespuesta datos) {
        Usuario autor = usuarioRepo.findById(datos.autorId()).orElseThrow();
        Topico topico = topicoRepo.findById(datos.topicoId()).orElseThrow();

        Respuesta r = new Respuesta();
        r.setMensaje(datos.mensaje());
        r.setAutor(autor);
        r.setTopico(topico);

        repository.save(r);
        return new DatosRespuestaRespuesta(r.getId(), r.getMensaje(), r.getFechaCreacion());
    }

    public List<DatosRespuestaRespuesta> listar() {
        return repository.findAll().stream()
                .map(r -> new DatosRespuestaRespuesta(r.getId(), r.getMensaje(), r.getFechaCreacion()))
                .toList();
    }
}

