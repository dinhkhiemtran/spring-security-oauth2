package com.example.springsecurityoauth2.controller;

import com.example.springsecurityoauth2.exception.ResourceNotFoundException;
import com.example.springsecurityoauth2.model.User;
import com.example.springsecurityoauth2.repository.UserRepository;
import com.example.springsecurityoauth2.security.CurrentUser;
import com.example.springsecurityoauth2.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}