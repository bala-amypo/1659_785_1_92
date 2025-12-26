// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;

// @RestController
// public class AuthController {

//     @Autowired
//     private UserService userservice;
    
//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userservice.register(user);
//     }
//     @PostMapping("/login")
//     public String login(@RequestBody User user) {

//         User existingUser = userservice.findByEmail(user.getEmail());

//         if (existingUser == null) {
//             return "User not found";
//         }

//         if (existingUser.getPassword().equals(user.getPassword())) {
//             return "Login successful";
//         }

//         return "Invalid password";
//     }
// }


package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.register(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");
            
            User user = userService.findByEmail(email);
            
            // Simple password check (in real app, use BCrypt)
            if (user.getPassword().equals(password)) {
                String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
                
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("role", user.getRole());
                
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


