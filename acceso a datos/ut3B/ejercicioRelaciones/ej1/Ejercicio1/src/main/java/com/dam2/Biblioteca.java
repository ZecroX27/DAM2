package com.dam2;

import jakarta.persistence.*;

@Entity
@Table ( name = "bibliotecas")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localidad;
}
