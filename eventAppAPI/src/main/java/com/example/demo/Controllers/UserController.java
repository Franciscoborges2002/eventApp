package com.example.demo.Controllers;


import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "{userId}")
    public User getUsersById(@PathVariable("userId") UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "type/{typeUser}")
    public List<User> getUsersByType(@PathVariable String typeUser) {
        //Verificar se a string vinda existe no TipoUtilizador
        return userService.getUserByType(typeUser);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        System.out.println("A receber utikizador par acriar");
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") UUID id) {
        System.out.println("A receber utikizador par eliminar");
        userService.deleteUser(id);
    }

    @PutMapping(path = "{userId}")//Receber utilizador inteiro do frontend
    public void updateUser(@PathVariable("userId") UUID id, @RequestBody User user) {
        System.out.println("A receber utikizador par mudar");
        userService.updateUser(id, user);
    }
}
