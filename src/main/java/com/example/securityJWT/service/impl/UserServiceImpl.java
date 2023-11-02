package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.User;
import com.example.securityJWT.pojo.UserPojo;
import com.example.securityJWT.repository.UserRepo;
import com.example.securityJWT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public User checkIt(Integer id) throws Exception {
        Optional<User> optionalUser = userRepo.findByUserId(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        throw new Exception("Id Not Found");
    }

    private final UserRepo userRepo;

    @Override
    public List<Map<String, Object>> getAll() {
        return userRepo.getAllUser();
    }

    @Override
    public UserPojo addUser(UserPojo userPojo) throws Exception {
        User user;
        if (userPojo.getId() != null)
            user = checkIt(userPojo.getId());
        else
            user = new User();
        user.setName(userPojo.getName());
        user.setContact(userPojo.getContact());
        user.setLocation(userPojo.getLocation());
        user.setUserName(userPojo.getUserName());
        user.setPassword(userPojo.getPassword());
        User result = userRepo.save(user);
        userPojo.setId(result.getId());
        return userPojo;
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        User user;
        user = checkIt(id);
        Boolean status = user.getStatus();
        user.setStatus(!status);
        userRepo.save(user);
    }
}
