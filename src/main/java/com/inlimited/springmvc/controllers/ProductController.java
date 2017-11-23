package com.inlimited.springmvc.controllers;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Viktor on 23.11.2017.
 */
@RestController
@EnableTransactionManagement
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/products")
    public List<Product> printProducts(){
        List<Product> products = productService.findAll();
        System.out.println(products.size());
        return products;
    }
}
