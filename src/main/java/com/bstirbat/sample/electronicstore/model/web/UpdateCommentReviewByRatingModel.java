package com.bstirbat.sample.electronicstore.model.web;

public class UpdateCommentReviewByRatingModel {
    private String comment;
    private Integer numberOfStars;

    public UpdateCommentReviewByRatingModel() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}
