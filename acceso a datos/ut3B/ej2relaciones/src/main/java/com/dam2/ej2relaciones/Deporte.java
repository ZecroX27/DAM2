package com.dam2.ej2relaciones;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "deportes")
public class Deporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    public Deporte() {
    }

    public Deporte(String nombre) {
        this.nombre = nombre;
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


    @Override
    public String toString() {
        return "Deporte{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
