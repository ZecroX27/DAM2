package com.dam2.servicioweb;

import java.util.List;

public interface ProductoService {
    List<Producto> findAllProducts();
    List<Producto> findAllProducts(String category);
    void increasePrice(Producto producto);
}
