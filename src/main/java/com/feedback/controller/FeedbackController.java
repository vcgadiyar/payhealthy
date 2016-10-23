package com.feedback.controller;

import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/getProductReview", method = RequestMethod.GET)
    public void getProductReview() {

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "Hello World!";
    }
}
