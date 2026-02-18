package com.dam2.servicioweb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    //List<Producto> findAll();
    Producto findByName(String name);
    List<Producto> findByNameAndPrice(String name, float price);
}