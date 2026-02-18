package com.dam2.ejemspringdisco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    private AlumnoServiceImpl dsi;

    @GetMapping("/existe/{id}")
    public boolean existeDisco(@PathVariable("id") Long id)
    {
        return dsi.existeDisco(id);
    }

    @GetMapping("/discos/{id}")
    public Optional<AlumnoDto> getDisco(@PathVariable("id") Long id)
    {
        return dsi.getDiscoById(id);
    }

    @GetMapping("/discos")
    public List<AlumnoDto> getDiscos()
    {
        return dsi.getAll();
    }

    @PostMapping("alta")
    public void guarda(@RequestBody AlumnoDto d)
    {
        dsi.guarda(d);
    }

    @PutMapping( "/libros/{id}")
    public AlumnoDto actualiza(@PathVariable Long id, @RequestBody AlumnoDto ad)
    {
        return dsi.actualiza(id,ad);
    }

    @DeleteMapping("/baja/{id}")
    public void  borra(@PathVariable Long id)
    {
        dsi.borra(id);
    }
}
