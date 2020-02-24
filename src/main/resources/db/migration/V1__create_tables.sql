CREATE TABLE products (
product_id int NOT NULL AUTO_INCREMENT,
product_name varchar(100) NOT NULL,
product_brand varchar(100) NOT NULL,
product_category varchar(50) NOT NULL,
Production_year int NOT NULL,
Product_price double NOT NULL,
PRIMARY KEY (product_id)
);

CREATE TABLE reviews (
review_id int NOT NULL AUTO_INCREMENT,
review_title varchar(100) DEFAULT NULL,
review_author varchar(50) NOT NULL,
review_status varchar(15) NOT NULL,
review_subject varchar(50) NOT NULL,
product_id int NOT NULL,
PRIMARY KEY (review_id),
FOREIGN KEY (product_id) REFERENCES products (product_id)
);

CREATE TABLE comments (
comment_id int NOT NULL AUTO_INCREMENT,
text varchar(1000) DEFAULT NULL,
review_id int NOT NULL,
PRIMARY KEY (comment_id),
FOREIGN KEY (review_id) REFERENCES reviews (review_id)
);

INSERT INTO products(product_name, product_brand, product_category, Production_year, Product_price) VALUES('Laptop', 'Lenovo', 'Notebook', 2017, 599.99);
INSERT INTO products(product_name, product_brand, product_category, Production_year, Product_price) VALUES('Laptop', 'HP', 'Ultrabook', 2016, 499.99);
INSERT INTO products(product_name, product_brand, product_category, Production_year, Product_price) VALUES('Laptop', 'Dell', 'Netbook', 2018, 399.99);
INSERT INTO products(product_name, product_brand, product_category, Production_year, Product_price) VALUES('Laptop', 'Acer', 'Tablet', 2018, 299.99);
INSERT INTO products(product_name, product_brand, product_category, Production_year, Product_price) VALUES('Laptop', 'Apple', 'MacBook', 2019, 999.99);

INSERT INTO reviews(review_title, review_author, review_status, review_subject, product_id) VALUES('Awesome', 'Client_1', 'Done', 'Lenovo', 1);
INSERT INTO reviews(review_title, review_author, review_status, review_subject, product_id) VALUES('Super', 'Client_3', 'Done', 'Dell', 3);
INSERT INTO reviews(review_title, review_author, review_status, review_subject, product_id) VALUES('Amazing', 'Client_5', 'Done', 'Apple', 5);

INSERT INTO comments(text, review_id) VALUES('It works as I expected, I advice you strongly to buy this product',1);
--'2017-01-09 15 −48 −23'

--post_date timestamp NULL DEFAULT NULL
--STR_TO_DATE('01-09-2017', '%m-%d-%y')

