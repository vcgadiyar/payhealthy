package com.feedback.controller;

import com.feedback.model.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Divakaran Jeyachandran
 */
@Controller
@RestController
public class FeedbackController {
    @RequestMapping(value = "/sendFeedback", method = RequestMethod.POST)
    public String postFeedback(@RequestBody Feedback feedback) {

        return "Success";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "Hello World!";
    }
}
