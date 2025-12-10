package com.dam2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table ( name = "bibliotecas")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localidad;
    @ManyToMany(mappedBy = "bibliotecas")
    private List<Libro> libros;

    public Biblioteca() {

    }
    public Biblioteca(String localidad) {
        this.localidad = localidad;
        libros = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
