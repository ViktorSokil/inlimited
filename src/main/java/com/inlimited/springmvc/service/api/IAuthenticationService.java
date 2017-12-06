package com.inlimited.springmvc.service.api;

import com.inlimited.springmvc.entity.User;

import java.util.List;

public interface IAuthenticationService {
    List<User> getAdmins();
}
