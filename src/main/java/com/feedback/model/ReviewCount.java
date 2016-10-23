package com.feedback.model;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
public class ReviewCount {
    private int numberOfTimes;
    private double total;

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
