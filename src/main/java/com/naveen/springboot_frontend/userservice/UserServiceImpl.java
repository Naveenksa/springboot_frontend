package com.naveen.springboot_frontend.userservice;

import com.naveen.springboot_frontend.UserRepo.UserRepo;
import com.naveen.springboot_frontend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);

    }
}
