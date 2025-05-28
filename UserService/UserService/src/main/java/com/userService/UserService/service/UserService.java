package com.userService.UserService.service;

import com.userService.UserService.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public User getUserById(String userId);
    public List<User> getAllUser();
}
