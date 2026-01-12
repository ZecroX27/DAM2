package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private int añoNacimiento;

    @OneToOne(mappedBy = "autor", cascade = CascadeType.PERSIST)
    private Biografia biografia;

    public Autor() {

    }

    public Autor(String nombre, int añoNacimiento, Biografia biografia) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        this.biografia = biografia;
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

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", añoNacimiento=" + añoNacimiento +
                ", biografia=" + biografia +
                '}';
    }
}
