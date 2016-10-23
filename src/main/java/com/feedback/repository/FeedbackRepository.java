package com.feedback.repository;

import com.feedback.model.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{
}
