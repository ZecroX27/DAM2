package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@DiscriminatorValue(value = "disco")
public class Disco extends Articulo  {
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
    public  Long  getId(){
        return super.getId();
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
