package com.example.demo.Controllers;

import com.example.demo.Models.Entity.Interaction;
import com.example.demo.Services.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("interaction")
public class InteractionController {

    private final InteractionService interactionService;

    @Autowired
    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping
    public List<Interaction> getInteractions() {
        return interactionService.getInteractions();
    }

    @GetMapping(path = "{InteractionId}")
    public Interaction getInteractionById(@PathVariable("InteractionId") UUID id) {
        return interactionService.getInteractionById(id);
    }

    @PostMapping
    public void addInteraction(@RequestBody Interaction Interaction) {
        System.out.println("A receber Interaction para criar");
        interactionService.addInteraction(Interaction);
    }

    @DeleteMapping(path = "{InteractionId}")
    public void deleteInteraction(@PathVariable("InteractionId") UUID id) {
        System.out.println("A receber Interaction par eliminar");
        interactionService.deleteInteraction(id);
    }

    @PutMapping(path = "{InteractionId}")//Receber utilizador inteiro do frontend
    public void updateInteraction(@PathVariable("InteractionId") UUID id, @RequestBody Interaction Interaction) {
        System.out.println("A receber Interaction par mudar");
        interactionService.updateInteraction(id, Interaction);
    }
}
