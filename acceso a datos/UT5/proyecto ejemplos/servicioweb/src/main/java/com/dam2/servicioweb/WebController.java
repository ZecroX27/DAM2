package com.dam2.servicioweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private ProductoService ps;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/catalogo")
    public String catalogo(Model model) {
        List<Producto> productos = ps.findAllProducts();
        model.addAttribute("productos", productos);
        return "catalogo";
    }
}
