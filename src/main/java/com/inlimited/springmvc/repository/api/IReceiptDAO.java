package com.inlimited.springmvc.repository.api;


import com.inlimited.springmvc.entity.Receipt;
import com.inlimited.springmvc.entity.User;

import java.util.List;

public interface IReceiptDAO {
    Receipt saveReceipt(Receipt receipt);
    Receipt findReceiptById(int receipt_id);
    List<Receipt> findAllReceipt();
    void updateReceipt(Receipt receipt);
    void deleteReceipt(Integer receiptId);
}
