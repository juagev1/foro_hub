package com.foro.hub.forohub.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    private com.foro.hub.forohub.model.Usuario autor;

    @ManyToOne
    private com.foro.hub.forohub.model.Topico topico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public com.foro.hub.forohub.model.Usuario getAutor() {
        return autor;
    }

    public void setAutor(com.foro.hub.forohub.model.Usuario autor) {
        this.autor = autor;
    }

    public com.foro.hub.forohub.model.Topico getTopico() {
        return topico;
    }

    public void setTopico(com.foro.hub.forohub.model.Topico topico) {
        this.topico = topico;
    }
}