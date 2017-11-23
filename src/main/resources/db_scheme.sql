CREATE TABLE  users
(user_id INT NOT NULL AUTO_INCREMENT,
 user_name VARCHAR(20) NOT NULL,
 user_email VARCHAR(20) NOT NULL UNIQUE,
  PRIMARY KEY (user_id),
);

CREATE TABLE  products
(product_id INT NOT NULL AUTO_INCREMENT,
 product_name VARCHAR(20) NOT NULL UNIQUE,
 product_price DECIMAL NOT NULL,
  PRIMARY KEY (product_id),
);

CREATE TABLE  receipts
(receipt_id INT NOT NULL AUTO_INCREMENT,
 receipt_date DATE NOT NULL,
 user_id INT NOT NULL,
 product_id INT NOT NULL,
  PRIMARY KEY (receipt_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id),
);

INSERT INTO products (product_name, product_price) VALUES ('sugar', 20);
INSERT INTO products (product_name, product_price) VALUES ('salt', 5);
INSERT INTO products (product_name, product_price) VALUES ('potato', 10);
INSERT INTO products (product_name, product_price) VALUES ('tea', 35);
INSERT INTO products (product_name, product_price) VALUES ('coffee', 50);
INSERT INTO products (product_name, product_price) VALUES ('cigarettes', 30);
INSERT INTO products (product_name, product_price) VALUES ('bear', 20);
INSERT INTO products (product_name, product_price) VALUES ('bread', 10);

COMMIT ;