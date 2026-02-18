package com.example.rsimple;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
// REST SIN JPA

@RestController
@RequestMapping("/users")
public class UserController {
   @GetMapping("/saluda")
    public String saluda(@RequestParam String nom)
    {
        if ((nom.isEmpty()) || (nom == null))
            return "Hola DAM2!";
        else
            return "Hola " + nom;
    }

    private List<String> users = new ArrayList<>();

	// curl -X GET localhost:8080/users
    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }
    // curl -POST -H "Content-Type: application/txt" -d pepe http://localhost:8080/users
    @PostMapping
    public String createUser(@RequestBody String user) {
        users.add(user);
        return "User created: " + user + "\n";
    }
	// curl -X DELETE localhost:8080/pepe
    @DeleteMapping("/{user}")
    public String deleteUser(@PathVariable("user") String user) {
        if (users.contains(user)) {
            users.remove(user);
            return "User deleted: " + user + "\n";
        }
        return "User not found\n";
    }
    // OBSERVA EL USO DE REQUESTPARAM Y PATHVARIABLE, HAY QUE DISTINGUIR CÓMO FUNCIONA UNO Y OTRO
}

