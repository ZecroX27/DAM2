package com.dam2;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name  = "libros")
@DiscriminatorValue(value = "libro")
public class Libro extends Articulo {
    private String isbn;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "autorId", joinColumns = {@JoinColumn(name = "id_libro")}, inverseJoinColumns = {@JoinColumn(name = "id_autor")})
    private List<Autor> autores;
    @ManyToMany
    @JoinTable(name="libros_biblios",joinColumns = {@JoinColumn(name = "id_libro")},inverseJoinColumns = {@JoinColumn(name = "id_biblioteca")})
    private List<Biblioteca> bibliotecas;
    @ManyToOne
    @JoinColumn(name = "editorialId")
    private Editorial editorial;

    public Libro() {
        autores = new ArrayList<>();
        bibliotecas = new ArrayList<>();

    }


    public Libro(String titulo, String isbn) {
        super(titulo);
        this.isbn = isbn;
        autores = new ArrayList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
