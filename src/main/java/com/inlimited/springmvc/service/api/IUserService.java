package com.inlimited.springmvc.service.api;

import com.inlimited.springmvc.entity.Product;
import com.inlimited.springmvc.entity.User;

import java.util.List;


public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    User saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
}
