package org.example.todoapp.service;

import org.example.todoapp.models.User;

public class UserService {
    public User getUserByUsername(String username) {
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }
}
