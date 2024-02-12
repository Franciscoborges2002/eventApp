package com.example.demo.Repositories;


import com.example.demo.Models.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InteractionRepository extends JpaRepository<Interaction, UUID> {
}
