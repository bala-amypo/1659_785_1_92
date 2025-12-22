package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepo;

    @Override
    public User register(User user) {
        return userrepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userrepo.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Invalid Email: " + email));
    }
}
