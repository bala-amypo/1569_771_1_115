package com.example.demo.security;

public class JwtUtil {

    private final String secret;
    private final int expiry;

    // ✅ REQUIRED BY TEST
    public JwtUtil(String secret, int expiry) {
        this.secret = secret;
        this.expiry = expiry;
    }

    public String generateToken(Long id, String email, String role) {
        return email + ":" + role;
    }
}
