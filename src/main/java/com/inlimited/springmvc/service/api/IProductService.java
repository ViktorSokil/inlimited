package com.inlimited.springmvc.service.api;

import com.inlimited.springmvc.entity.Product;

import java.util.List;


public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long productId);
}
