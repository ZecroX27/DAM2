package com.dam2.mvc;
// MVC
public class patronMVC {

    public static void main(String args[]) {

        Ventana view = new Ventana();
        VentanaModel model = new VentanaModel();
        VentanaController controller = new VentanaController(model, view);
    }
}
