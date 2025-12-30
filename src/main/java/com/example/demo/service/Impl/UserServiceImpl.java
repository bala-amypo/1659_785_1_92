// package com.example.demo.service.Impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.service.UserService;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.model.User;
// import com.example.demo.exception.ResourceNotFoundException;

// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepository userrepo;

//     @Override
//     public User register(User user) {
//         return userrepo.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userrepo.findByEmail(email)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Invalid Email: " + email));
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            
            throw new IllegalArgumentException("User email already exists");
        }
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ANALYST");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }
}