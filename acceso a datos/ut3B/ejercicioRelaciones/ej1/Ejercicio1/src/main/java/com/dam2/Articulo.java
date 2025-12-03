package com.dam2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {
    @Id

    private Long id;
    private String titulo;

    public Articulo() {
    }
    public Articulo(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}
