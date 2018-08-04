package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Review;

import java.util.List;

public interface ReviewService {

    Review findById(long id);

    Review save(Review review);

    Review update(Review review);

    List<Review> findByItem(long itemId);
}
