package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void injected_components_are_not_null(){
        assertNotNull(dataSource);
        assertNotNull(jdbcTemplate);
        assertNotNull(entityManager);
        assertNotNull(testEntityManager);
        assertNotNull(commentRepository);
    }

    @Test
    public void comment_repository_returns_comments_by_review(){

        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductBrand("Test product brand");
        product.setCategory("Test product category");
        product.setYearOfProduction(2020);
        product.setProductPrice(123.35);
        entityManager.persist(product);


        Review review = new Review();
        review.setReview_title("Test Review");
        review.setReviewAuthor("Test author");
        review.setReviewStatus("Test status");
        review.setReviewSubject("Test Subject");
        review.setProduct(product);
        entityManager.persist(review);


        Comment comment1 = new Comment();
        comment1.setText("Test comment detail 1");
        comment1.setReview(review);
        entityManager.persist(comment1);


        Comment comment2 = new Comment();
        comment2.setText("Test comment detail 2");
        comment2.setReview(review);
        entityManager.persist(comment2);


        List<Comment> comments = commentRepository.findAllByReview(review);


        assertNotNull(comments);
        assertEquals(2, comments.size());
        assertTrue(comments.contains(comment1));
        assertTrue(comments.contains(comment2));
    }


}