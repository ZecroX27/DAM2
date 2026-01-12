package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "biografia_id")
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String descripcion) {
        this.descripcion = descripcion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Biografia{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", autor=" + autor +
                '}';
    }
}
