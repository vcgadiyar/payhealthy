package com.feedback.service;

import com.feedback.model.Feedback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.feedback.model.Review;
import com.feedback.model.ReviewCount;
import com.feedback.repository.FeedbackRepository;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
@Service
public class FeedbackService {

    private Logger logger = Logger.getLogger(FeedbackService.class);
    @Autowired
    private FeedbackRepository repository;

    public void saveFeedback(Feedback feedback) {
        repository.save(feedback);
        logger.info("feedback saved!");
    }

    public List<Feedback> getAllReviews() {
        List<Feedback> feedbacks = (List<Feedback>) repository.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(feedbacks);
        logger.info(json);
        logger.info("feedback retrieved");
        return feedbacks;
    }

    public List<Feedback> getMerchantProducts(int merchantId) {
        List<Feedback> feedbacks = (List<Feedback>) repository.findAll();
        List<Feedback> resultSet = new ArrayList<>();
        for(Feedback feedback : feedbacks) {
            if(feedback.getMerchantId() == merchantId) {
                resultSet.add(feedback);
            }
        }
        logger.info("Feedbacks for merchant retrieved");
        return resultSet;
    }

    public List<Feedback> getProductReview(int merchantId, int itemId) {
        List<Feedback> feedbacks = (List<Feedback>) repository.findAll();
        List<Feedback> resultSet = new ArrayList<>();
        for(Feedback feedback : feedbacks) {
            if(feedback.getMerchantId() == merchantId && feedback.getIntemId() == itemId) {
                resultSet.add(feedback);
            }
        }
        logger.info("Feedbacks for product retrieved");
        return resultSet;
    }

    public List<Review> getAggregatedProductReview(int merchantId) {
        List<Feedback> feedbacks = (List<Feedback>) repository.findAll();
        Map<String, ReviewCount> map = new HashMap<>();
        for(Feedback feedback : feedbacks) {
            if(feedback.getMerchantId() == merchantId) {
                if (map.containsKey(feedback.getItemName())) {
                    ReviewCount reviewCount = map.get(feedback.getItemName());
                    reviewCount.setNumberOfTimes(reviewCount.getNumberOfTimes() + 1);
                    reviewCount.setTotal(reviewCount.getTotal() + feedback.getReviewStars());
                    map.put(feedback.getItemName(), reviewCount);
                } else {
                    ReviewCount reviewCount = new ReviewCount();
                    reviewCount.setNumberOfTimes(1);
                    reviewCount.setTotal(feedback.getReviewStars());
                    map.put(feedback.getItemName(), reviewCount);
                }

            }

        }
        List<Review> reviewItems = new ArrayList<>();
        for(Map.Entry<String, ReviewCount> entry : map.entrySet()) {
            double value = round(entry.getValue().getTotal()/entry.getValue().getNumberOfTimes(), 2);
            Review review = new Review();
            review.setItemName(entry.getKey());
            review.setReviewStars(value);
            reviewItems.add(review);
        }
        logger.info("Aggregated review for products retrieved");
        return reviewItems;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

//    List<Feedback> feedbacks = (List<Feedback>) repository.findAll();
//    Map<String, ReviewCount>= new HashMap<>();
//    double numberOfItems = 0;
//    double total = 0;
//    for(Feedback feedback : feedbacks) {
//        if(feedback.getMerchantId() == merchantId) {
//            total += feedback.getReviewStars();
//            numberOfItems++;
//        }
//    }
//    logger.info("Feedbacks for product retrieved");
//    double value = total/numberOfItems;
//    return round(value,2);


}
