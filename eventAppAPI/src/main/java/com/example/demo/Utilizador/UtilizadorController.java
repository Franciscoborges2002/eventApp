package com.example.demo.Utilizador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "utilizador")
public class UtilizadorController {
    private final UtilizadorService utilizadorService;

    @Autowired
    public UtilizadorController(UtilizadorService utilizadorService) {
        this.utilizadorService = utilizadorService;
    }

    @GetMapping
    public List<Utilizador> getUtilizadores() {
        return utilizadorService.getUtilizadores();
    }

    @GetMapping(path = "{utilizadorId}")
    public Utilizador getUtilizadorById(@PathVariable("utilizadorId") Long id) {
        return utilizadorService.getUtilizadorById(id);
    }

    @GetMapping(path = "tipo/{tipoUtilizador}")
    public Utilizador getUtilizadorByType(@PathVariable String tipoUtilizador) {

        //Verificar se a string vinda existe no TipoUtilizador
        return utilizadorService.getUtilizadorByType(tipoUtilizador);
    }

    @PostMapping
    public void registarNo(@RequestBody Utilizador utilizador) {
        System.out.println("A receber utikizador par acriar");
        utilizadorService.addNewUtilizador(utilizador);
    }

    @DeleteMapping(path = "{utilizadorId}")
    public void deleteUtilizador(@PathVariable("utilizadorId") Long id) {
        System.out.println("A receber utikizador par eliminar");
        utilizadorService.deleteUtilizador(id);
    }

    @PutMapping(path = "{utilizadorId}")
    public void updateUtilizador(@PathVariable("utilizadorId") Long id, @RequestBody Utilizador utilizador) {
        System.out.println("A receber utikizador par mudar");
        utilizadorService.updateUtilizador(id, utilizador);
    }
}
