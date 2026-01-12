package com.dam2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "libro")
public class Libro extends Articulo{
    @Column
    private String isbn;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = " libros_autores", joinColumns = {@JoinColumn(name = "libro_id")}, inverseJoinColumns = {@JoinColumn(name = "autor_id")})
    private List<Autor> autores;
    @ManyToMany(mappedBy = "libros", cascade = CascadeType.PERSIST)
    private List<Biblioteca> bibliotecas;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "libro_id")
    private Editorial editorial;

    public Libro() {

    }

    public Libro(String titulo, String isbn, Editorial editorial) {
        super(titulo);
        this.isbn = isbn;
        this.editorial = editorial;
        bibliotecas = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", autores=" + autores +
                ", bibliotecas=" + bibliotecas +
                ", editorial=" + editorial +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
