package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int año_nacimiento;
    @OneToOne(mappedBy = "autor", cascade = CascadeType.PERSIST) //Como autor tiene una relacion 1 A 1 con biografia debemos de hacer un mappedBy
    private Biografia biografia;
    public Autor() {

    }
    public Autor(String nombre, int año_nacimiento) {
        this.nombre = nombre;
        this.año_nacimiento = año_nacimiento;

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

    public int getAño_nacimiento() {
        return año_nacimiento;
    }

    public void setAño_nacimiento(int año_nacimiento) {
        this.año_nacimiento = año_nacimiento;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }
}
