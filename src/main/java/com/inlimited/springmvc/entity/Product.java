package com.inlimited.springmvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Viktor on 23.11.2017.
 */
@Entity
@Table(name = "products")
public class Product {
    private int productId;
    private String productName;
    private BigDecimal productPrice;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRODUCT_NAME", nullable = false, length = 20)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "PRODUCT_PRICE", nullable = false, precision = 32767)
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product products = (Product) o;

        if (productId != products.productId) return false;
        if (productName != null ? !productName.equals(products.productName) : products.productName != null)
            return false;
        if (productPrice != null ? !productPrice.equals(products.productPrice) : products.productPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        return result;
    }
}
