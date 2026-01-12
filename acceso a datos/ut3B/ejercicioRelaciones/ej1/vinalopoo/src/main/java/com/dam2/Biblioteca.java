package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bibliotecas")
public class Biblioteca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String localidad;
    @ManyToMany
    @JoinTable(name = "biblio_libros", joinColumns = {@JoinColumn(name = "id_biblio")}, inverseJoinColumns = {@JoinColumn(name = "id_libros")})
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

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", localidad='" + localidad + '\'' +
                ", libros=" + libros +
                '}';
    }
}
