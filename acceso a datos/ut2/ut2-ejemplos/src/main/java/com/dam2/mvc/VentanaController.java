package com.dam2.mvc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaController implements ActionListener/*, KeyListener*/ {

    private VentanaModel model;
    private Ventana view;

    private int posicion;

    public VentanaController(VentanaModel model, Ventana view) {
        this.model = model;
        this.view = view;
        anadirActionListener(this);
        //anadirKeyListener(this);

        posicion = 0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String actionCommand = event.getActionCommand();
        Empleado Empleado = null;

        switch (actionCommand) {
            case "Nuevo":
                view.tfNom.setText("");
                view.tfNom.setEditable(true);
                view.tfSalario.setText("");
                view.tfSalario.setEditable(true);
                view.tfId.setText("");
                view.tfId.setEditable(true);
                view.btGuardar.setEnabled(true);
                break;
            case "Guardar":

                if (view.tfNom.getText().equals("")) {
                    Util.mensajeError("El nombre es un campo obligatorio", "Nuevo Empleat");
                    return;
                }

                Empleado = new Empleado();
                Empleado.setNom(view.tfNom.getText());
                Empleado.setId(Integer.parseInt(view.tfId.getText()));
                Empleado.setSalario(Double.parseDouble(view.tfSalario.getText()));

                model.guardar(Empleado);

                view.btGuardar.setEnabled(false);
                break;
            case "Modificar":
                Empleado = new Empleado();
                Empleado.setNom(view.tfNom.getText());
                Empleado.setId(Integer.parseInt(view.tfId.getText()));
                Empleado.setSalario(Double.parseDouble(view.tfSalario.getText()));
                model.modificar(Empleado);
                break;
            case "Cancelar":
                view.tfNom.setEditable(false);
                view.tfSalario.setEditable(false);
                view.tfId.setEditable(false);

                Empleado = model.getActual();
                cargar(Empleado);

                view.btGuardar.setEnabled(false);
                break;
            case "Eliminar":
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                    return;

                model.eliminar();
                Empleado = model.getActual();
                cargar(Empleado);
                break;
/*            case "Buscar":
                Empleat = model.buscar(view.tfBusqueda.getText());
                if (Empleat == null) {
                    Util.mensajeInformacion("No se ha encontrado ningún Empleat con ese nombre", "Buscar");
                    return;
                }
                cargar(Empleat);
                break;*/
            case "|<":
                Empleado = model.getPrimero();
                cargar(Empleado);
                break;
            case "<":
                Empleado = model.getAnterior();
                cargar(Empleado);
                break;
            case ">":
                Empleado = model.getSiguiente();
                cargar(Empleado);
                break;
            case ">|":
                Empleado = model.getUltimo();
                cargar(Empleado);
                break;
            default:
                break;
        }
    }

/*    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == view.tfBusqueda) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.btBuscar.doClick();
            }
        }
    }*/

    /**
     * Carga los datos de un Empleat en la vista
     * @param Empleado
     */
    private void cargar(Empleado Empleado) {
        if (Empleado == null)
            return;

        view.tfNom.setText(Empleado.getNom());
        view.tfSalario.setText(String.valueOf(Empleado.getSalario()));
        view.tfId.setText(String.valueOf(Empleado.getId()));
    }

/*    private void anadirKeyListener(KeyListener listener) {
        view.tfBusqueda.addKeyListener(listener);
    }
*/
    private void anadirActionListener(ActionListener listener) {

        view.btNuevo.addActionListener(listener);
        view.btGuardar.addActionListener(listener);
        view.btModificar.addActionListener(listener);
        view.btEliminar.addActionListener(listener);
        view.btPrimero.addActionListener(listener);
        view.btAnterior.addActionListener(listener);
        view.btSiguiente.addActionListener(listener);
        view.btUltimo.addActionListener(listener);
 //       view.btBuscar.addActionListener(listener);
    }
}
