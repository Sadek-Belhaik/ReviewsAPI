package com.udacity.course3.reviews.MongoDbRepository;

import com.udacity.course3.reviews.document.MongoDbReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoDbReviewRepository extends MongoRepository<MongoDbReview, String> {
    List<MongoDbReview> findReviewsByProductId(int productId);
}
