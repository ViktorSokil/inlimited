package com.inlimited.springmvc.repository.api;

import com.inlimited.springmvc.entity.User;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Viktor on 23.11.2017.
 */
public interface IUserDAO {
    void saveUser(User user);
    User findUserById(int user_id);
    List<User> findAllUsers();
    void updateUser(User user);
    void deleteUser(Integer userId);
}
