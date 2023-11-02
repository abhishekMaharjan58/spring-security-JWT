package com.example.securityJWT.service;

import com.example.securityJWT.model.User;
import com.example.securityJWT.pojo.UserPojo;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<String, Object>> getAll();

    UserPojo addUser(UserPojo userPojo) throws Exception;

    void deleteUser(Integer id) throws Exception;

    User checkIt(Integer id) throws Exception;
}
