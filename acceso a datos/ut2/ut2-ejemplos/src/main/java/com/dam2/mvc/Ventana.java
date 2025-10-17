package com.dam2.mvc;

import javax.swing.*;
import java.awt.*;

public class Ventana {
    private JPanel panel1,panel2,panel3;
    JTextField tfNom;
    JTextField tfId;
    JTextField tfSalario;

    JLabel lNom;
    JLabel lId;
    JLabel lSalario;

    JButton btGuardar;
    JButton btNuevo;
    JButton btModificar;
    JButton btEliminar;
    JButton btAnterior;
    JButton btSiguiente;
    JButton btPrimero;
    JButton btUltimo;
//    JBarraEstado barraEstado;
//    JTextField tfBusqueda;
//    JButton btBuscar;

    public Ventana() {

        JFrame frame = new JFrame("Ventana");
        panel1 = new JPanel(new GridLayout(0,1));
        frame.setContentPane(panel1);
        panel2 = new JPanel(new GridLayout(4,2));
        panel3 = new JPanel(new GridLayout(2,4));
        panel1.add(panel2); panel1.add(panel3);
        lNom = new JLabel("Nom:");
        tfNom = new JTextField("");
        panel2.add(lNom); panel2.add(tfNom);
        lId = new JLabel("Id:");
        tfId = new JTextField("");
        panel2.add(lId); panel2.add(tfId);
        lSalario = new JLabel("Salari:");
        tfSalario = new JTextField("");
        panel2.add(lSalario); panel2.add(tfSalario);

        btNuevo = new JButton("Nuevo");
        btGuardar = new JButton("Guardar");
        btModificar = new JButton("Modificar");
        btEliminar = new JButton("Eliminar");
        btPrimero = new JButton("|<");
        btAnterior = new JButton("<");
        btSiguiente = new JButton(">");
        btUltimo = new JButton(">|");
        panel3.add(btGuardar);  panel3.add(btNuevo);  panel3.add(btModificar);  panel3.add(btEliminar);
        panel3.add(btPrimero);  panel3.add(btAnterior);  panel3.add(btSiguiente);  panel3.add(btUltimo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
