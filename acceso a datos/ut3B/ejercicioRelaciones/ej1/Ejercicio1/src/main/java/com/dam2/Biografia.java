package com.dam2;

import jakarta.persistence.*;

@Entity
@Table(name = "biografias")
public class Biografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
}
