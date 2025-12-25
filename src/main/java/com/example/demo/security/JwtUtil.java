package com.example.demo.security;

public class JwtUtil {

    public JwtUtil() {}

    public JwtUtil(String secret, int expiry) {}

    public String generateToken(String email) {
        return "dummy-token";
    }
}
