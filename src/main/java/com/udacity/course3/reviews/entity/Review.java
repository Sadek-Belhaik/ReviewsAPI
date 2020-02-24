package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(name = "review_title")
    private String review_title;

    @Column(name = "review_author")
    private String reviewAuthor;


    @Column(name = "review_status")
    private String reviewStatus;



    @Column(name = "review_subject")
    private String reviewSubject;

    @OneToMany(mappedBy = "review", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Review() {
    }


//    public Review(String review_title, String reviewAuthor, String reviewStatus, String reviewSubject) {
////        this.reviewId = reviewId;
//        this.review_title = review_title;
//        this.reviewAuthor = reviewAuthor;
//        this.reviewStatus = reviewStatus;
//        this.reviewSubject = reviewSubject;
////        counter++;
////        this.product = product;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getReviewSubject() {
        return reviewSubject;
    }

    public void setReviewSubject(String reviewSubject) {
        this.reviewSubject = reviewSubject;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

//    @Override
//    public String toString() {
//        return "Review{" +
//                "reviewId=" + reviewId +
//                ", review_title='" + review_title + '\'' +
//                ", reviewAuthor='" + reviewAuthor + '\'' +
//                ", reviewStatus=" + reviewStatus + '\'' +
//                ", reviewSubject=" + reviewSubject + '\'' +
//                '}';
//    }
}

