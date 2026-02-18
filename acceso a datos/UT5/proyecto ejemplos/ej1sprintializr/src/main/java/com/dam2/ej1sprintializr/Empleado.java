package com.dam2.ej1sprintializr;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "empleados")
public class Empleado implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @Column
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

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                '}';
    }
}
