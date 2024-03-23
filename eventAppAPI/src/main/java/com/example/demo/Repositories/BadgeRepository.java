package com.example.demo.Repositories;

import com.example.demo.Models.Entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BadgeRepository extends JpaRepository<Badge, UUID> {

    Optional<Badge> findBadgeById(UUID id);

    Optional<Badge> findBadgeByName(String name);


}
