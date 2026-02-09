package com.dam2.ej1spring;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor          //Crea el constructor sin parametros
@AllArgsConstructor         //Crea el constructor con parametros
@Data                       //Crea los getters y los setters
@Entity                     //Indicamos que es una entidad
@Table(name = "empleado")   //Nombre de la tabla
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column
    private Double salario;



}

