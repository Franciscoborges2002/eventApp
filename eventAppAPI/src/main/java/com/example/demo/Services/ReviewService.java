package com.example.demo.Services;

import com.example.demo.Models.Badge;
import com.example.demo.Models.Review;
import com.example.demo.Repositories.CompanyRepository;
import com.example.demo.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    public List<Review> getReviews() {
        return reviewRepository.findAll();

    }

    public Review getReviewById(UUID id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);

        if (!reviewOptional.isPresent()) {
            throw new IllegalStateException("Não existe review com esse id");
        }

        return reviewOptional.get();
    }

    public void addReview(Review review) {

        reviewRepository.save(review);
    }

    public void deleteReview(UUID id) {
        boolean bool = reviewRepository.existsById(id);

        if (!bool) {
            throw new IllegalStateException(("Not exists any badge with that id!"));
        }

        reviewRepository.deleteById(id);
    }

    public void updateReview(UUID id, Review review) {
    }
}
