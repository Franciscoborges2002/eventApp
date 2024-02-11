package com.example.demo.Repositories;

import com.example.demo.Enums.TypeContract;
import com.example.demo.Models.Badge;
import com.example.demo.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface BadgeRepository extends JpaRepository<Badge, UUID> {

    Optional<Badge> findBadgeById(UUID id);

    Optional<Badge> findBadgeByName(String name);


}
