package com.inlimited.springmvc.service.impl;

import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.repository.api.IUserDAO;
import com.inlimited.springmvc.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;



    @Override
    public List<User> findAll() {
        return userDAO.findAllUsers();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDAO.deleteUser(userId);
    }
}
