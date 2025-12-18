package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;

@Service
public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
}
