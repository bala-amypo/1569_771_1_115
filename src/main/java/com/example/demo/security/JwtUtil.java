package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component   // ✅ THIS IS THE FIX
public class JwtUtil {

    private final String secret;
    private final int expiry;

    // REQUIRED BY TESTS
    public JwtUtil(String secret, int expiry) {
        this.secret = secret;
        this.expiry = expiry;
    }

    public String generateToken(Long id, String email, String role) {
        return email + ":" + role;
    }
}
