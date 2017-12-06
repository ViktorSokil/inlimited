package com.inlimited.springmvc.service.impl;

import com.inlimited.springmvc.entity.User;
import com.inlimited.springmvc.service.api.IAuthenticationService;
import com.inlimited.springmvc.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("authenticationService")
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private IUserService userService;

    @Override
    public List<User> getAdmins() {
        List<User> users = userService.findAll();
        return users
                .stream()
                .filter(user -> "ADMIN".equals(user.getRole()))
                .collect(Collectors.toList());
    }
}
