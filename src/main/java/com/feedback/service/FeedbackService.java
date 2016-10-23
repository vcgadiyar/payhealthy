package com.feedback.service;

import com.feedback.model.Feedback;
import com.feedback.repository.FeedbackRepository;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void getProductReview(int merchantId, int productId) {
        //Feedback feedback = repository.
    }
}
