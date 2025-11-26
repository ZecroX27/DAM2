package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
    private List<Empleado> empleados;

    public Empresa() {

    }

    public Empresa(String nom) {
        this.nom = nom;
        empleados = new ArrayList<Empleado>();
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Long getId() {
        return id;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
