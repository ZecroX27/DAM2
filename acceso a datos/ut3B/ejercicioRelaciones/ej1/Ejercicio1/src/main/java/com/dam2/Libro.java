package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name  = "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int isbn;

    public Libro() {
    }
    public Libro(Long id, int isbn) {
        this.id = id;
        this.isbn = isbn;
    }
}
