package com.udacity.course3.reviews.MongoDbRepository;

import com.udacity.course3.reviews.document.MongoDbReview;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDbReviewRepositoryTest {

    @Autowired
    private MongoDbReviewRepository mongoDbReviewRepository;

    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")
    @Test
    public void create_new_review() {

        MongoDbReview review = new MongoDbReview();
        review.setProductId(1);
        review.setReviewDetail("test review");
        review.setComments(Arrays.asList("test comment 1", "test comment 2"));
        mongoDbReviewRepository.save(review);

        Optional<MongoDbReview> optionalReview = mongoDbReviewRepository.findById(review.getId());
        Assert.assertTrue(optionalReview.isPresent());
        Assert.assertEquals(optionalReview.get().getReviewDetail(),"test review");
    }

    @Test
    public void fetch_reviews_by_product_id() {

        MongoDbReview review = new MongoDbReview();
        review.setProductId(1);
        review.setReviewDetail("test review");
        review.setComments(Arrays.asList("test comment 1", "test comment 2"));
        mongoDbReviewRepository.save(review);

        List<MongoDbReview> reviews = mongoDbReviewRepository.findReviewsByProductId(1);
        Assert.assertEquals(reviews.size(), 1);
        Assert.assertEquals(reviews.get(0).getComments().size(), 2);
    }
}