package com.inlimited.springmvc.controllers;


import com.inlimited.springmvc.entity.Receipt;
import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.service.api.IReceiptService;
import com.inlimited.springmvc.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private IReceiptService receiptService;

    @RequestMapping(value = "/receipts",method = RequestMethod.POST)
    public String makeOrder(@RequestBody Receipt receipt){
        return receiptService.saveReceipt(receipt).getReceiptId().toString();
    }
}
