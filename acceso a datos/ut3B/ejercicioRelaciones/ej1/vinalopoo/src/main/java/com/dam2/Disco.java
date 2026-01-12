package com.dam2;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "disco")
public class Disco extends Articulo {
    @Column
    private int duracion;

    public Disco() {
    }

    public Disco(String titulo, int duracion) {
        super(titulo);
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
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
