package com.inlimited.springmvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping(value = "/login")
    public String admin(){
        System.out.println("In admin");
        return "signin";
    }

    @RequestMapping(value = "/admin/dashboard")
    public String getDashboard(){
        System.out.println("In admin");
        return "dashboard";
    }
}
