package com.example.demo.Repositories;

import com.example.demo.Models.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {


}
