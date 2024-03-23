package com.example.demo.Repositories;

import com.example.demo.Models.Entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ValidationRepository extends JpaRepository<Validation, UUID> {
}
