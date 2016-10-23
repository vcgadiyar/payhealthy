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

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        double total = 2+3+3;
        System.out.println(total/3);
        System.out.println(round(total/3, 1));

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
