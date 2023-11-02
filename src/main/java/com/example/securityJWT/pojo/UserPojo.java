package com.example.securityJWT.pojo;

import lombok.Data;

@Data
public class UserPojo {
    private Integer id;

    private String name;

    private String location;

    private String contact;

    private String userName;

    private String password;
}
