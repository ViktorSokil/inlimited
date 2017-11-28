package com.inlimited.springmvc.controllers;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.service.api.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/products/{productId}")
    public Product printProduct(@PathVariable Long productId){
        return productService.findById(productId);
    }

    @RequestMapping(value = "/admin/products",method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product){
        productService.saveProduct(product);

    }

    @RequestMapping(value = "/admin/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.PUT)
    public String editProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "products";
    }

}
