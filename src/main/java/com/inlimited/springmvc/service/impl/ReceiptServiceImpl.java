package com.inlimited.springmvc.service.impl;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.entity.Receipt;
import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.repository.api.IReceiptDAO;
import com.inlimited.springmvc.service.api.IReceiptService;
import com.inlimited.springmvc.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service("receiptService")
public class ReceiptServiceImpl implements IReceiptService {

    @Autowired
    private IReceiptDAO receiptDAO;

    @Autowired
    private IUserService userService;

    @Override
    public List<Receipt> findAll() {
        return receiptDAO.findAllReceipt();
    }

    @Override
    public Receipt findById(Long id) {
        return receiptDAO.findReceiptById(id);
    }

    @Override
    public Receipt saveReceipt(Receipt receipt) {
        User user = receipt.getUser();
        if(user != null){
            user.setRole("USER");
            user = userService.saveUser(user);
        }
        receipt.setUser(user);
        receipt.setReceiptDate(getDate());
        receipt.setTotalPrice(countTotalPrice(receipt));
        return receiptDAO.saveReceipt(receipt);
    }

    @Override
    public void updateReceipt(Receipt receipt) {
        receiptDAO.updateReceipt(receipt);
    }

    @Override
    public void deleteReceipt(Integer receiptId) {
        receiptDAO.deleteReceipt(receiptId);
    }

    private BigDecimal countTotalPrice(Receipt receipt){
        BigDecimal totalPrice = new BigDecimal(0);
        List<Product> products = receipt.getProducts();
        for (Product  product: products){
            totalPrice = totalPrice.add(product.getProductPrice());
        }
        return totalPrice;
}

    private Date getDate(){
        java.util.Date date = new java.util.Date();
        return new Date(date.getTime());
    }
}
