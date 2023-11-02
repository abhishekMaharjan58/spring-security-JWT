package com.example.securityJWT.controller;

import com.example.securityJWT.pojo.UserPojo;
import com.example.securityJWT.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/")
    public List<Map<String, Object>> getAllUsers() {
        try {
            return userService.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return (List<Map<String, Object>>) ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> addUser(@RequestBody UserPojo userPojo) {
        try {
            return ResponseEntity.ok(userService.addUser(userPojo));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }

    @Transactional
    @Modifying
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Deleted Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body(ex.getLocalizedMessage());
        }
    }
}
