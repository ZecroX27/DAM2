package com.dam2;

import jakarta.persistence.*;

@Entity
@Table ( name = "editoriales")

public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
