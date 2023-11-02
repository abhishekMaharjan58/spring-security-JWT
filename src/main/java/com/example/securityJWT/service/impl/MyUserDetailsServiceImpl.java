package com.example.securityJWT.service.impl;

import com.example.securityJWT.model.MyUserDetails;
import com.example.securityJWT.model.User;
import com.example.securityJWT.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepo.findByUserName(userName);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Not found" + userName));
        User user = optionalUser.get();
        return new MyUserDetails(user);
    }

//        if(userName.equals(name))
//            return new User("abhi","abhi", new ArrayList<>()) {
//        };
//        else
//            throw new UsernameNotFoundException("User Not Found");
//    }

}
