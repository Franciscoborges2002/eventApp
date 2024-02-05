package com.example.demo.Repositories;

import com.example.demo.Models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ValidationRepository extends JpaRepository<Validation, UUID> {
}
