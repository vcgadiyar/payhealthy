package com.feedback.model;

/**
 * @author Divakaran Jeyachandran
 */
public class Item {
    private int intemId;
    private String itemName;
    private int reviewStars;
    private String reviewComments;

    public int getIntemId() {
        return intemId;
    }

    public void setIntemId(int intemId) {
        this.intemId = intemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }
}
