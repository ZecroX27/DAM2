package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "discos")
public class Disco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duracion;

    public Disco() {
    }

    public Disco(Long id, int duracion) {
        this.id = id;
        this.duracion = duracion;
    }
}
