package com.example.projects.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "jwt_tokens")
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "token",nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User userId;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "expires_at")
    private Date expiresAt;

    public JwtToken() {}
    public JwtToken(String token, User userId) {
        this.setToken(token);
        this.setUserId(userId);
    }

    // Setters and Getters here...

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public User getUserId() {
        return this.userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

}
