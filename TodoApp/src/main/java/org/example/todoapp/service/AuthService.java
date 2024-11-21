package org.example.todoapp.service;

import org.example.todoapp.models.User;

public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public boolean register(String username, String password) {
        try {
            // Check if user already exists
            User existingUser = userService.getUserByUsername(username);
            if (existingUser != null) {
                System.out.println("User already exists!");
                return false;
            }

            // todo: hash password

            // Add user
            return userService.addUser(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(String username, String password) {
        try {
            User user = userService.getUserByUsername(username);

            // If user does not exist
            if (user == null) {
                System.out.println("User not found!");
                return false;
            }

            // todo: hash password

            // Validate credentials
            return user.getPassword().equals(password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
