package com.inlimited.springmvc.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Viktor on 23.11.2017.
 */
@Entity
@Table(name = "receipts")
public class Receipt {
    private int receiptId;
    private Date receiptDate;
    private int productId;

    @Id
    @Column(name = "RECEIPT_ID", nullable = false)
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Basic
    @Column(name = "RECEIPT_DATE", nullable = false)
    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "PRODUCT_ID", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipts = (Receipt) o;

        if (receiptId != receipts.receiptId) return false;
        if (productId != receipts.productId) return false;
        if (receiptDate != null ? !receiptDate.equals(receipts.receiptDate) : receipts.receiptDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = receiptId;
        result = 31 * result + (receiptDate != null ? receiptDate.hashCode() : 0);
        result = 31 * result + productId;
        return result;
    }
}
