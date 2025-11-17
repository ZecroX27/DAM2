package com.dam2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements java.io.Serializable {
    private  Long id; //Primary key
    private String nom;
    private double salario;

    public Empleado() {

    }

    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
