package com.dashboard.service.impl;


import com.dashboard.entity.User;
import com.dashboard.repository.UserRepository;
import com.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String registerUser(User user) {
        System.out.println("Registering user: " + user.getEmail());
        System.out.println("Encoded password: " + passwordEncoder.encode(user.getPassword()));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

}
