package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Review;

public interface ReviewService {

    Review findById(long id);

    Review save(Review review);

    Review update(Review review);
}
