package com.example.demo.security;

public class JwtUtil {

    private final String secret;
    private final int expiry;

    public JwtUtil(String secret, int expiry) {
        this.secret = secret;
        this.expiry = expiry;
    }

    public String generateToken(Long userId, String email, String role) {
        return userId + "|" + email + "|" + role;
    }

    public String extractEmail(String token) {
        try { return token.split("\\|")[1]; }
        catch (Exception e) { return null; }
    }

    public String extractRole(String token) {
        try { return token.split("\\|")[2]; }
        catch (Exception e) { return null; }
    }

    public Long extractUserId(String token) {
        try { return Long.parseLong(token.split("\\|")[0]); }
        catch (Exception e) { return null; }
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }
}
