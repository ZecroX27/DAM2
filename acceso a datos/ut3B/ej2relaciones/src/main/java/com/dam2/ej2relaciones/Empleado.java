package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;    // clave primaria
    @Column(name ="nombre")
    protected String nom;

    @Column
    protected double salario;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    protected Empresa empresa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Deporte deporte;

    @OneToOne(mappedBy = "empleado",  cascade = CascadeType.PERSIST)
    protected Usuario usuario;

    public Empleado() {
    }
    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;
    }
    public Empleado(String nom, double salario, Empresa empresa) {
        this.nom = nom;
        this.salario = salario;
        this.empresa = empresa;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", empresa=" + empresa +
                '}';
    }
}
