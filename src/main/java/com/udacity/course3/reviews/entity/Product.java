package com.udacity.course3.reviews.entity;

import com.udacity.course3.reviews.document.MongoDbReview;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @NotBlank
    @Column(name = "product_name")
    private String productName;

    @NotBlank
    @Column(name = "product_brand")
    private String productBrand;

    @NotBlank
    @Column(name = "product_category")
    private String category;

    @Column(name = "Production_year")
    private int yearOfProduction;

    @Column(name = "Product_price")
    private double productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Review> reviews;

    @Transient
    private List<MongoDbReview> mongoDbReviews;

    public Product() {}

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(int productId, @NotBlank String productName, @NotBlank String productBrand, @NotBlank String category, @NotBlank int yearOfProduction, @NotBlank double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.category = category;
        this.yearOfProduction = yearOfProduction;
        this.productPrice = productPrice;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public List<MongoDbReview> getMongoDbReviews() {
        return mongoDbReviews;
    }

    public void setMongoDbReviews(List<MongoDbReview> mongoDbReviews) {
        this.mongoDbReviews = mongoDbReviews;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", productName='" + productName + '\'' +
//                ", productBrand='" + productBrand + '\'' +
//                ", category=" + category + '\'' +
//                ", yearOfProduction=" + yearOfProduction + '\'' +
//                ", productPrice=" + productPrice +
//                '}';
//    }


}
