package com.dam2;

import jakarta.persistence.*;

@Entity
@Table(name = "biografias")
public class Biografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "autores_id")
    private Autor autor;

    public Biografia() {

    }
    public Biografia(String descripcion, Autor autor) {
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
