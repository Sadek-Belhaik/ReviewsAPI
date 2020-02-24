package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;

    @Column(name = "text")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;


    public Comment() {
    }


    public Comment(int commentId, String text, Timestamp postDate, Review review) {
        this.commentId = commentId;
        this.text = text;
        this.review = review;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

//    @Override
//    public String toString() {
//        return "Comment{" +
//                "commentId=" + commentId +
//                ", text='" + text + '\'' +
//                ", postDate=" + postDate +
//                '}';
//    }

}
