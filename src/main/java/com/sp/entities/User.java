package com.sp.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "role")
    private UserRoles role;

    public Long getUser_id() {
        return user_id;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password, UserRoles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @Override
    public String toString() {
        return String.format("[id = %d, name = %s, password = %s]", user_id, username, password);
    }
}
