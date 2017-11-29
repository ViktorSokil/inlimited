package com.inlimited.springmvc.service.api;


import com.inlimited.springmvc.entity.Receipt;

import java.util.List;

public interface IReceiptService {
    List<Receipt> findAll();
    Receipt findById(Long id);
    Receipt saveReceipt(Receipt receipt);
    void updateReceipt(Receipt receipt);
    void deleteReceipt(Integer receiptId);
}
