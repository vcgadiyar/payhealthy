package com.feedback.controller;

import com.feedback.model.Feedback;
import com.feedback.model.Review;
import com.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Divakaran Jeyachandran
 */
@Controller
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService service;

    @RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
    public String postFeedback(@RequestBody Feedback feedback) {
        service.saveFeedback(feedback);
        return "Feedback saved successfully";
    }

    @RequestMapping(value = "/getReviews", method = RequestMethod.GET)
    public List<Feedback> getReviews() {
        return service.getAllReviews();
    }

    @RequestMapping(value = "/getMerchantProducts/{merchantId}", method = RequestMethod.GET)
    public List<Feedback> getMerchantReview(@PathVariable int merchantId) {
        return service.getMerchantProducts(merchantId);
    }

    @RequestMapping(value = "/getProductReview/{merchantId}/{itemId}", method = RequestMethod.GET)
    public List<Feedback> getProductReview(@PathVariable int merchantId, @PathVariable int itemId) {
        return service.getProductReview(merchantId, itemId);
    }

    @RequestMapping(value = "/getAggregateReview/{merchantId}", method = RequestMethod.GET)
    public List<Review> getAggProductReview(@PathVariable int merchantId) {
        return service.getAggregatedProductReview(merchantId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "Hello World!";
    }
}
