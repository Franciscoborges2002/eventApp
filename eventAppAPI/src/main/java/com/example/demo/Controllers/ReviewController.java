package com.example.demo.Controllers;

import com.example.demo.Models.Entity.Review;
import com.example.demo.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("review")
public class ReviewController {
    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping(path = "{reviewId}")
    public Review getReviewById(@PathVariable("reviewId") UUID id) {
        return reviewService.getReviewById(id);
    }


    @PostMapping
    public void addReview(@RequestBody Review review) {
        System.out.println("A receber review para criar");
        reviewService.addReview(review);
    }

    @DeleteMapping(path = "{reviewId}")
    public void deleteReview(@PathVariable("reviewId") UUID id) {
        System.out.println("A receber reviewId par eliminar");
        reviewService.deleteReview(id);
    }

    @PutMapping(path = "{reviewId}")//Receber utilizador inteiro do frontend
    public void updateReview(@PathVariable("reviewId") UUID id, @RequestBody Review review) {
        System.out.println("A receber badge par mudar");
        reviewService.updateReview(id, review);
    }
}
