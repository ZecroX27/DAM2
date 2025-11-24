package com.dam2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "productos")
public class Productos {

    /* Si se produce el error de duplicidad de "productos" cambiamos la correspondiente
    anotación de productos en el getter
     */
    private List<Producto> productos;

    public Productos() {
        productos = new ArrayList<>();
    }

    public Productos(List<Producto> productos) {
        this.productos = productos;
    }
    @XmlElement(name = "producto")
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Productos { " +
                "productos = " + productos +
                '}';
    }
}
