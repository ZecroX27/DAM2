package ej2relaciones;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados;

    public Empresa() {

    }

    public Empresa(String nom) {
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
