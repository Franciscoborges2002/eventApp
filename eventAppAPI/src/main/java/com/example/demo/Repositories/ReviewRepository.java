package com.example.demo.Repositories;

import com.example.demo.Models.Company;
import com.example.demo.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {


}
