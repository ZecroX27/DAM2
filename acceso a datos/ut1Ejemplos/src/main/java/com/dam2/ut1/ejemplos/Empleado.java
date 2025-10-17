package com.dam2.ut1.ejemplos;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Empleado {
    private int id;
   // @XmlElement(name = "nomcomplet")
    private String nom;
    private double salario;

    public Empleado() {
    }

    public Empleado(int id, String nom, double salario) {
        this.id = id;
        this.nom = nom;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleat{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salari=" + salario +
                '}';
    }
}
