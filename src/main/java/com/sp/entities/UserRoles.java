package com.sp.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "role")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserRoles() {
    }

    public UserRoles(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("[id = %d, role = %s]", id, role);
    }
}
