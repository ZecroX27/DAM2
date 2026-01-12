package com.dam2.ch;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable {
    @Id
    private String num;
    @ManyToOne
    @JoinColumn(name = "personaId")
    private Persona persona;

    public Telefono() {
    }

    public Telefono(String num, Persona persona) {
        this.num = num;
        this.persona = persona;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "num='" + num + '\'' +
                ", persona=" + persona.getNom() +
                '}';
    }
}
