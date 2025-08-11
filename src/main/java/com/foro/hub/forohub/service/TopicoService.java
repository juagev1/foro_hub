package com.foro.hub.forohub.service;


import com.foro.hub.forohub.Dto.*;
import com.foro.hub.forohub.model.Topico;
import com.foro.hub.forohub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public DatosRespuestaTopico crear(DatosRegistroTopico datos) {
        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());

        repository.save(topico);

        return new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }

    public List<DatosRespuestaTopico> listar() {
        return repository.findAll()
                .stream()
                .map(t -> new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getFechaCreacion()))
                .toList();
    }

    public DatosRespuestaTopico obtener(Long id) {
        Topico t = repository.findById(id).orElseThrow();
        return new DatosRespuestaTopico(t.getId(), t.getTitulo(), t.getMensaje(), t.getFechaCreacion());
    }

    public DatosRespuestaTopico actualizar(Long id, DatosActualizarTopico datos) {
        Topico topico = repository.findById(id).orElseThrow();
        if (datos.titulo() != null) topico.setTitulo(datos.titulo());
        if (datos.mensaje() != null) topico.setMensaje(datos.mensaje());

        repository.save(topico);

        return new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion());
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

