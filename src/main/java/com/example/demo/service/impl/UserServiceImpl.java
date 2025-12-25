package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
