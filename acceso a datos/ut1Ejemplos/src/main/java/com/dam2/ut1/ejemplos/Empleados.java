package com.dam2.ut1.ejemplos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="empleados")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Empleados {
    @XmlElement(name="empleado")
    private List<Empleado> empleados;

    public Empleados() {
    }

    public Empleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empleats{" +
                "empleats=" + empleados +
                '}';
    }
}
