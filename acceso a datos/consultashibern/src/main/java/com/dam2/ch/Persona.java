package com.dam2.ch;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @Column
    private String direccion;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Telefono> tlfs;
    public Persona() {
    }

    public Persona(String nom, String direccion) {
        this.nom = nom;
        this.direccion = direccion;
        tlfs = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Telefono> getTlfs() {
        return tlfs;
    }

    public void setTlfs(List<Telefono> tlfs) {
        this.tlfs = tlfs;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tlfs=" + tlfs +
                '}';
    }
}
