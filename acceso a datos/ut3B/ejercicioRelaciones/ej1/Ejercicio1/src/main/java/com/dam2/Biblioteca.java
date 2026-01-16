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
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "biblio_libros", joinColumns = {@JoinColumn(name = "id_biblio")}, inverseJoinColumns = {@JoinColumn (name = "libros_id")})
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

    public void addLibros(Libro libro) {
        libros.add(libro);
    }
}
