package com.inlimited.springmvc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "receipts")
public class Receipt {
    @Id
    @Column(name = "RECEIPT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId;
    @Column(name = "RECEIPT_DATE", nullable = false)
    private Date receiptDate;
    @Column(name = "TOTAL_PRICE", nullable = false)
    private BigDecimal totalPrice;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "receipts_product", joinColumns = @JoinColumn(name = "RECEIPT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal productId) {
        this.totalPrice = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (!receiptId.equals(receipt.receiptId)) return false;
        if (!receiptDate.equals(receipt.receiptDate)) return false;
        if (!totalPrice.equals(receipt.totalPrice)) return false;
        if (!products.equals(receipt.products)) return false;
        return user.equals(receipt.user);
    }

    @Override
    public int hashCode() {
        int result = receiptId.hashCode();
        result = 31 * result + receiptDate.hashCode();
        result = 31 * result + totalPrice.hashCode();
        result = 31 * result + products.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
