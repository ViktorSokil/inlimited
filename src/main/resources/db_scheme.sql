DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS products;

DROP TABLE IF EXISTS receipts;

DROP TABLE IF EXISTS receipts_product;


CREATE TABLE  users
(user_id INT NOT NULL AUTO_INCREMENT,
 user_name VARCHAR(20) NOT NULL,
 user_email VARCHAR(20) NOT NULL ,
 role VARCHAR (10),
 password VARCHAR (15),
 PRIMARY KEY (user_id)
);

CREATE TABLE  products
(product_id INT NOT NULL AUTO_INCREMENT,
 product_name VARCHAR(20) NOT NULL,
 product_price DECIMAL NOT NULL,
 PRIMARY KEY (product_id)
);

CREATE TABLE  receipts
(receipt_id INT NOT NULL AUTO_INCREMENT,
 receipt_date DATE NOT NULL,
 user_id INT NOT NULL,
 total_price DECIMAL NOT NULL,
 PRIMARY KEY (receipt_id)
);

CREATE TABLE receipts_product
(receipt_id INT NOT NULL ,
 product_id INT NOT NULL,
PRIMARY KEY (receipt_id, product_id),
FOREIGN KEY (receipt_id) REFERENCES receipts (receipt_id) ,
FOREIGN KEY (product_id) REFERENCES products (product_id));

/*products*/
INSERT INTO products (product_name, product_price) VALUES ('Bora', 200);
INSERT INTO products (product_name, product_price) VALUES ('Sofia', 250);
INSERT INTO products (product_name, product_price) VALUES ('Julia', 300);
INSERT INTO products (product_name, product_price) VALUES ('Laura', 350);
INSERT INTO products (product_name, product_price) VALUES ('Coffee', 330);
INSERT INTO products (product_name, product_price) VALUES ('Solid', 500);
INSERT INTO products (product_name, product_price) VALUES ('Marta', 230);
INSERT INTO products (product_name, product_price) VALUES ('Soft', 340);

INSERT INTO users (user_name, user_email, role, password) VALUES ('Admin 1', 'admin1@gmail.com', 'ADMIN', 'pass1');
INSERT INTO users (user_name, user_email, role, password) VALUES ('Admin 2', 'admin2@gmail.com', 'ADMIN', 'pass2');

COMMIT ;