package com.example.demo.dto;

public class LoginResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    // REQUIRED BY TESTS
    public LoginResponse() {}

    // REQUIRED (for simple token return)
    public LoginResponse(String token) {
        this.token = token;
    }

    // REQUIRED: THIS IS WHAT FIXES THE ERROR
    public LoginResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // GETTERS (tests call getToken())
    public String getToken() { return token; }
    public Long getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    // SETTERS (some tests may need them)
    public void setToken(String token) { this.token = token; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}
