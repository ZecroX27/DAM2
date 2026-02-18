package com.rca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Libro {

    private String titulo = "Acceso a Datos";
    @Autowired
    private Autor autor;
    private String genero = "programación";
    private String editorial = "Paco Mollà";
    private int edicion = 1;
    private int paginas = 999;

    public Libro() {
    }

    public Libro(String titulo, Autor autor, String genero, String editorial, int edicion, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editorial = editorial;
        this.edicion = edicion;
        this.paginas = paginas;
    }
// Getters y Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
}