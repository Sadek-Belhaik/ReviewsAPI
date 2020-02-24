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
public class ReviewRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void injected_components_are_not_null(){
        assertNotNull(dataSource);
        assertNotNull(jdbcTemplate);
        assertNotNull(entityManager);
        assertNotNull(testEntityManager);
        assertNotNull(reviewRepository);
    }

    @Test
    public void review_repository_returns_reviews_by_product(){

        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductBrand("Test product brand");
        product.setCategory("Test product category");
        product.setYearOfProduction(2020);
        product.setProductPrice(123.35);
        entityManager.persist(product);


        Review review1 = new Review();
        review1.setReview_title("Test Review 1");
        review1.setReviewAuthor("Test author 1");
        review1.setReviewStatus("Test status 1");
        review1.setReviewSubject("Test Subject 1");
        review1.setProduct(product);
        entityManager.persist(review1);

        Review review2 = new Review();
        review2.setReview_title("Test Review 2");
        review2.setReviewAuthor("Test author 2");
        review2.setReviewStatus("Test status 2");
        review2.setReviewSubject("Test Subject 2");
        review2.setProduct(product);
        entityManager.persist(review2);

        List<Review> reviews = reviewRepository.findAllByProduct(product);


        assertNotNull(reviews);
        assertEquals(2, reviews.size());
        assertTrue(reviews.contains(review1));
        assertTrue(reviews.contains(review2));
    }

}