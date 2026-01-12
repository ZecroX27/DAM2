package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "articulos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    protected String titulo;

    public Articulo() {

    }

    public Articulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
