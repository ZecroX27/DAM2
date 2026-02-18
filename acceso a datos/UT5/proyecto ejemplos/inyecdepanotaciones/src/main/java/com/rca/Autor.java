package com.rca;

import org.springframework.stereotype.Component;

@Component
public class Autor {

    private String nombre ;
    private String apellido ;

    public Autor() {
        this.nombre = "Ricardo";
        this.apellido = "Cantó";
    }

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
// Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
