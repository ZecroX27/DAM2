package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.GregorianCalendar;


@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // clave primaria
    @Column(name ="nombre")
    private String nom;
    @Column
    private double salario;

    @Column
    private GregorianCalendar fecha;

    public Empleado() {
    }

    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;    }


    public Empleado(GregorianCalendar fecha, double salario, String nom, Long id) {
        this.fecha = fecha;
        this.salario = salario;
        this.nom = nom;
        this.id = id;
    }

    public GregorianCalendar setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    public GregorianCalendar getFecha() {
        return fecha;
    }
    public Long getId() {
        return id;
    }

/*    public void setId(Long id) {
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
