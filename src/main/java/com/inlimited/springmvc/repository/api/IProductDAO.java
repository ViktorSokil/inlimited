package com.inlimited.springmvc.repository.api;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.entity.User;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Viktor on 23.11.2017.
 */
public interface IProductDAO {
    void saveProduct(Product product);
    Product findProductById(int product_id);
    List<Product> findAllProducts();
    void updateProduct(Product product);
    void deleteProduct(Integer productId);
}
