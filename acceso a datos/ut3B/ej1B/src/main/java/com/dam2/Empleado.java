package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "empleados")

public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "nombre")
    private String nom;

    @Column
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre, double salario) {
        this.nom = nombre;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nom;
    }

    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nom + '\'' +
                ", salario=" + salario +
                '}';
    }
}
