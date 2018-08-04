package com.bstirbat.sample.electronicstore.controller;

import com.bstirbat.sample.electronicstore.model.db.Item;
import com.bstirbat.sample.electronicstore.model.db.Review;
import com.bstirbat.sample.electronicstore.model.web.ReviewModel;
import com.bstirbat.sample.electronicstore.service.ItemService;
import com.bstirbat.sample.electronicstore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        Review review = reviewService.findById(id);

        if (review == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(review);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody ReviewModel reviewModel) {

        if (reviewModel.getId() != null) {
            return ResponseEntity.badRequest().body("No id should be given.");
        }

        if (reviewModel.getItemId() == null) {
            return ResponseEntity.badRequest().body("No item id given.");
        }

        Item itemById = itemService.findById(reviewModel.getItemId());
        if (itemById == null) {
            return ResponseEntity.badRequest().body("No item found for given id: " + reviewModel.getItemId());
        }

        Review newReview = new Review();
        newReview.setItem(itemById);
        newReview.setNumberOfStars(reviewModel.getNumberOfStars());
        newReview.setComment(reviewModel.getComment());

        Review review = reviewService.save(newReview);

        return ResponseEntity.ok(review);
    }

    @PutMapping(value = "/update")
    public ResponseEntity update(@RequestBody ReviewModel reviewModel) {

        if (reviewModel.getId() == null) {
            return ResponseEntity.badRequest().body("No id given.");
        }

        Review review = reviewService.findById(reviewModel.getId());

        if (reviewModel.getItemId() != null && reviewModel.getItemId() != review.getItem().getId()) {
            Item newItem = itemService.findById(reviewModel.getItemId());
            review.setItem(newItem);
        }

        if (reviewModel.getNumberOfStars() != null) {
            review.setNumberOfStars(reviewModel.getNumberOfStars());
        }

        if (reviewModel.getComment() != null) {
            review.setComment(reviewModel.getComment());
        }

        Review updatedReview = reviewService.update(review);
        return ResponseEntity.ok(updatedReview);
    }
}
