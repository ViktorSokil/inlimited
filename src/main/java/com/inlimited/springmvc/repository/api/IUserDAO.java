package com.inlimited.springmvc.repository.api;

import com.inlimited.springmvc.entity.User;
import org.hibernate.SessionFactory;

import java.util.List;


public interface IUserDAO {
    User saveUser(User user);
    User findUserById(Long user_id);
    List<User> findAllUsers();
    void updateUser(User user);
    void deleteUser(Long userId);
}
