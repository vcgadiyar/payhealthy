package com.feedback.model;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
public class Review {
    private String itemName;
    private double reviewStars;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(double reviewStars) {
        this.reviewStars = reviewStars;
    }
}
