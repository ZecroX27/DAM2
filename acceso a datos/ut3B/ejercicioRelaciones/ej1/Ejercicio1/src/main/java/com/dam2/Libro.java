package com.dam2;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "libro")
public class Libro extends Articulo {
    private String isbn;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "biblios_libros", joinColumns= {@JoinColumn(name = "libro_id")}, inverseJoinColumns = {@JoinColumn(name = "biblioteca_id")})
    private List<Biblioteca> bibliotecas;
    @ManyToMany
    @JoinTable(name = "autores_libros", joinColumns = {@JoinColumn(name = "libro_id")}, inverseJoinColumns = {@JoinColumn(name = "autor_id")})
    private List<Autor> autores;

    public Libro() {
        bibliotecas = new ArrayList<>();
        autores = new ArrayList<>();
    }

    public Libro(String titulo, String isbn) {
        super(titulo);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return super.getTitulo();
    }
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }
    public Long  getId() {
        return super.getId();
    }
    public void setId(Long id) {}
    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
