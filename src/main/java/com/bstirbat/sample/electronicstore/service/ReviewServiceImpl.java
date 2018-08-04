package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Review;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

public class ReviewServiceImpl implements ReviewService {

    private EntityManager entityManager;

    public ReviewServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Review findById(long id) {
        return entityManager.find(Review.class, id);
    }

    @Override
    @Transactional
    public Review save(Review review) {
        entityManager.persist(review);
        return review;
    }

    @Override
    @Transactional
    public Review update(Review review) {
        return entityManager.merge(review);
    }
}
