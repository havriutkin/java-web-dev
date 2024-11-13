package org.example.todoapp.service;

import org.example.todoapp.models.User;

public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean register(String username, String password) {
        // Implement this method
        return false;
    }

    public boolean login(String username, String password) {
        // Get user
        User user;
        try {
            user = userService.getUserByUsername(username);
        } catch (Exception e) {
            return false;
        }

        // print user name and password
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        // Check if the username and password are correct
        return user.getPassword().equals(password);
    }
}
