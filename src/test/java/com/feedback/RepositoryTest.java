package com.feedback;

import com.feedback.config.PersistentConfiguration;
import com.feedback.model.Feedback;
import com.feedback.model.Item;
import com.feedback.repository.FeedbackRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */

public class RepositoryTest {

    private FeedbackRepository productRepository;

    @Autowired
    public void setProductRepository(FeedbackRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Test
//    public void testDatabase() {
//        Date date = new Date();
//        Feedback feedback = new Feedback();
//        feedback.setCustomerId(1);
//        feedback.setMerchantId(10);
//        feedback.setTimestamp(date.getTime());
//        feedback.setUsername("divakaran");
//        Item item = new Item();
//        item.setIntemId(23);
//        item.setItemName("Naan");
//        item.setReviewComments("Good");
//        item.setReviewStars(3);
//        feedback.setItem(item);
//
//        Assert.assertNull(feedback.getId());
//        productRepository.save(feedback);
//        Assert.assertNotNull(feedback.getId());
    @Test
    public void test() throws InterruptedException {
        Date date = new Date();
        System.out.println(date.getTime());
        Thread.sleep(1000);
        System.out.println(date.getTime());

    }
}
