package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;

    private LocalDateTime createdAt;

    public User() {}

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== GETTERS (REQUIRED) =====
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {     // 🔴 missing before
        return email;
    }

    public String getPassword() {  // 🔴 missing before
        return password;
    }

    public String getRole() {
        return role;
    }

    // ===== SETTERS =====
    public void setId(Long id) {
        this.id = id;
    }

    public void
