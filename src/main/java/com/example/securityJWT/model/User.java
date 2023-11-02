package com.example.securityJWT.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userName"}, name = "unique_userName"),})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String name;

    private String location;

    private String contact;

    private String userName;

    private String password;

    private Boolean status = true;

    private Boolean isAdmin = false;

    private String roles = "USER";
}
