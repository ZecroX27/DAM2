package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
//@Table(name = "discos")
@DiscriminatorValue( value = "disco")
public class Disco extends Articulo {
    private int duracion;

    public Disco() {
    }

    public Disco(int duracion) {
        this.duracion = duracion;
    }
    public Disco(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
