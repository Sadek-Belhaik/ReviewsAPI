package com.udacity.course3.reviews.document;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class MongoDbReview {

    @Id
    private String id;

    private String reviewDetail;

    private int productId;

    private List<String> comments = new ArrayList<>();

    public MongoDbReview() {
    }

    // Create document after saving review
    public MongoDbReview(Review review) {
        this.productId = review.getProduct().getId();
        this.reviewDetail = review.getReviewSubject();
        if (review.getComments() != null) {
            for (Comment comment : review.getComments()) {
                comments.add(comment.getText());
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReviewDetail() {
        return reviewDetail;
    }

    public void setReviewDetail(String reviewDetail) {
        this.reviewDetail = reviewDetail;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}

