package com.dam2.ej1sprintializr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@Controller
@ResponseBody */
@RestController
public class WebController {
    @Autowired
    private EmpleadoServiceImpl esi;

    //@RequestMapping(method = RequestMethod.GET, value =/lista)
    //@GetMapping(value = "/lista")
    // retornar todos los empleados
    // curl -X GET localhost:8080/lista
    @GetMapping("/lista")
    public List<Empleado> listaTodos()
    {
        return esi.findAll();
    }

    // retornar un solo empleado a partir del id
    //  curl -X GET localhost:8080/lista/1
    @GetMapping("/lista/{id}")
    public Optional<Empleado> listaPorId(@PathVariable Long id)
    {
        return esi.findById(id);
    }

    //@RequestMapping(method = RequestMethod.POST)
    // añadir un nuevo empleado
    //  curl -X POST localhost:8080/alta -d '{"nom":"Pepe Pérez","salario":2222}' -H "Content-Type: application/json"
    @PostMapping("/alta")
    public void alta(@RequestBody Empleado emp)
    {
        esi.saveEmpleado(emp);
    }


    // modificar un empleado dado su id
    // curl -X PUT localhost:8080/modifica/1 -d '{"nom":"Bad Bunny","salario":1111}' -H "Content-Type: application/json"
    @PutMapping("/modifica/{id}")
    public Empleado modificaEmpleado(@PathVariable Long id, @RequestBody Empleado emp)
    {
        return esi.updateEmpleado(id,emp);
    }

    // borrar un empleado por id
    // curl -X DELETE localhost:8080/baja/1
    @DeleteMapping("/baja/{id}")
    public void baja(@PathVariable Long id)
    {
        esi.deleteEmpleado(id);
    }
}
