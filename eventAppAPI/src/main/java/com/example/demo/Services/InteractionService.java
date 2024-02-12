package com.example.demo.Services;

import com.example.demo.Models.Interaction;
import com.example.demo.Models.Interaction;
import com.example.demo.Repositories.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InteractionService {
    private final InteractionRepository interactionRepository;

    @Autowired
    public InteractionService(InteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }


    public List<Interaction> getInteractions() {
        return interactionRepository.findAll();
    }

    public Interaction getInteractionById(UUID id) {
        Optional<Interaction> InteractionById = interactionRepository.findById(id);

        if (!InteractionById.isPresent()) {
            throw new IllegalStateException("Não existe Interaction com esse id");
        }

        return InteractionById.get();
    }


    public void addInteraction(Interaction interaction) {
   // é preciso alguma verificação ??? -
        interactionRepository.save(Interaction);
    }

    public void deleteInteraction(UUID id) {
        boolean bool = interactionRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Not exists any Interaction with that id!"));
        }

        interactionRepository.deleteById(id);
    }

    public void updateInteraction(UUID id, Interaction Interaction) {
    }
}
