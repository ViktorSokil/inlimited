package com.inlimited.springmvc.service.api;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.repository.api.IProductDAO;

import java.util.List;

/**
 * Created by Viktor on 23.11.2017.
 */
public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer productId);
}
