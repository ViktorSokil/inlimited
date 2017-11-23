package com.inlimited.springmvc.service.impl;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.repository.api.IProductDAO;
import com.inlimited.springmvc.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDAO productDAO;

    public ProductServiceImpl(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAllProducts();
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findProductById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Integer productId) {

    }
}
