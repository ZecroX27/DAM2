package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreusuario")
    private String login;

    @Column(name = "password")
    private String passwd;

    @OneToOne()
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String login, String passwd,  Empleado empleado) {
        this.login = login;
        this.passwd = passwd;
        this.empleado = empleado;
    }

    public Usuario(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getpasswd() {
        return passwd;
    }

    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
