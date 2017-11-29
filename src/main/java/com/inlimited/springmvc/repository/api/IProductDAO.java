package com.inlimited.springmvc.repository.api;

import com.inlimited.springmvc.entity.Product;

import java.util.List;


public interface IProductDAO {
    void saveProduct(Product product);
    Product findProductById(Long product_id);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Long productId);
}
