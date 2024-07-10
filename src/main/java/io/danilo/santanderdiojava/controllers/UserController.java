package io.danilo.santanderdiojava.controllers;

import io.danilo.santanderdiojava.model.User;
import io.danilo.santanderdiojava.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User novaUsario = userService.create(user);
        return ResponseEntity.created(URI.create("/users/" + novaUsario.getId())).body(novaUsario);
    }
}
