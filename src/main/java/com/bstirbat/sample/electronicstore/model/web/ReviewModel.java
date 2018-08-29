package com.bstirbat.sample.electronicstore.model.web;

public class ReviewModel {

    private Long id;
    private Long itemId;
    private Integer numberOfStars;
    private String comment;

    public ReviewModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(Integer numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ReviewModel{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", numberOfStars=" + numberOfStars +
                ", comment='" + comment + '\'' +
                '}';
    }
}
