package ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    public Empleado() {
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
