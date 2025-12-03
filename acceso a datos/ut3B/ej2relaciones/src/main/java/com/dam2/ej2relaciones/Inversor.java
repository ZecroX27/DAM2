package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "inversores")
public class Inversor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)

    @ManyToMany(mappedBy = "inversores")
    private List<Empresa> empresas;

    public Inversor(String nombre, List<Empresa> empresas) {
        this.nombre = nombre;
        this.empresas = empresas;
    }
    public Inversor(String nombre) {
        this.nombre = nombre;
        empresas = new ArrayList<>();
    }

    public Inversor() {

    }
}
