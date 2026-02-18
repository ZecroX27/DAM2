package com.rca;

public class Libro {

    private String titulo;
    private Autor autor;
    private String genero;
    private String editorial;
    private int edicion;
    private int paginas;

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