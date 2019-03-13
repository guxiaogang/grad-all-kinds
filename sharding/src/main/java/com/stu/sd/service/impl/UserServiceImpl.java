package com.stu.sd.service.impl;


import com.stu.sd.model.User;
import com.stu.sd.repository.UserRepo;
import com.stu.sd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }
}
