package com.example.demo.Controllers;


import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "utilizador")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService utilizadorService) {
        this.userService = utilizadorService;
    }

    @GetMapping
    public List<User> getUtilizadores() {
        return userService.getUsers();
    }

    @GetMapping(path = "{utilizadorId}")
    public User getUtilizadorById(@PathVariable("utilizadorId") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "tipo/{tipoUtilizador}")
    public User getUtilizadorByType(@PathVariable String tipoUtilizador) {

        //Verificar se a string vinda existe no TipoUtilizador
        return userService.getUserByType(tipoUtilizador);
    }

    @PostMapping
    public void registarNo(@RequestBody User utilizador) {
        System.out.println("A receber utikizador par acriar");
        userService.addUser(utilizador);
    }

    @DeleteMapping(path = "{utilizadorId}")
    public void deleteUtilizador(@PathVariable("utilizadorId") Long id) {
        System.out.println("A receber utikizador par eliminar");
        userService.deleteUser(id);
    }

    @PutMapping(path = "{utilizadorId}")//Receber utilizador inteiro do frontend
    public void updateUtilizador(@PathVariable("utilizadorId") Long id, @RequestBody User utilizador) {
        System.out.println("A receber utikizador par mudar");
        userService.updateUser(id, utilizador);
    }
}
