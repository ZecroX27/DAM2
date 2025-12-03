package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int añoNacimiento;
}
