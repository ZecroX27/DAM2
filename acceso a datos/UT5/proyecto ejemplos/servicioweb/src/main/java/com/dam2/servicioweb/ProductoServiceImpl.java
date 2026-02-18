package com.dam2.servicioweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository pr;

    @Override
    public List<Producto> findAllProducts() {
        return (List<Producto>) pr.findAll();
    }

    @Override
    public List<Producto> findAllProducts(String category) {
        return null;
    }

    @Override
    public void increasePrice(Producto producto) {

    }
}
