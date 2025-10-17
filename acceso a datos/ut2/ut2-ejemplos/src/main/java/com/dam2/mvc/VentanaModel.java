package com.dam2.mvc;

import java.util.ArrayList;

public class VentanaModel {

    private ArrayList<Empleado> listaEmpleados;
    private int posicion;

    public VentanaModel() {
        listaEmpleados = new ArrayList<>();
        posicion = 0;
    }

    /**
     * Guarda un Empleat en la lista
     * @param Empleado
     */
    public void guardar(Empleado Empleado) {

        listaEmpleados.add(Empleado);
        posicion++;
        System.out.println(posicion);
        for (Empleado a: listaEmpleados)
            System.out.println(a);
    }

    /**
     * Modifica los datos del Empleat actual
     * @param empleadoModificado
     */
    public void modificar(Empleado empleadoModificado) {

        Empleado Empleado = listaEmpleados.get(posicion);
        Empleado.setNom(empleadoModificado.getNom());
        Empleado.setSalario(empleadoModificado.getSalario());
        Empleado.setId(empleadoModificado.getId());
    }

    /**
     * Elimina el Empleat actual
     */
    public void eliminar() {
        listaEmpleados.remove(posicion);
    }

    public Empleado getActual() {

        return listaEmpleados.get(posicion);
    }

    /**
     * Busca un Empleat en la lista
     * @param nombre El nombre del Empleat
     * @return El Empleat o null si no se ha encontrado nada
     */
/*    public Empleat buscar(String nombre) {
        for (Empleat Empleat : listaEmpleates) {
            if (Empleat.getNom().equals(nombre)) {
                return Empleat;
            }
        }

        return null;
    }*/

    /**
     * Obtiene el Empleat que está en primera posición en la lista
     * @return
     */
    public Empleado getPrimero() {

        posicion = 0;
        return listaEmpleados.get(posicion);
    }

    /**
     * Obtiene el Empleat que está en la posición anterior a la actual
     * @return
     */
    public Empleado getAnterior() {

        if (posicion == 0)
            return null;

        posicion--;
        return listaEmpleados.get(posicion);
    }

    /**
     * Obtiene el Empleat que está en la posición siguiente a la actual
     * @return
     */
    public Empleado getSiguiente() {

        if (posicion == listaEmpleados.size() - 1)
            return null;

        posicion++;
        return listaEmpleados.get(posicion);
    }

    /**
     * Obtiene el Empleat que está en la última posición de la lista
     * @return
     */
    public Empleado getUltimo() {

        posicion = listaEmpleados.size() - 1;
        return listaEmpleados.get(posicion);
    }
}
