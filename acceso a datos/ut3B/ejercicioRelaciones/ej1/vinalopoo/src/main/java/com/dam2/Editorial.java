package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editorial")
public class Editorial  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {

    }

    public Editorial(String nombre) {
        this.nombre = nombre;
        libros = new ArrayList<Libro>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}
