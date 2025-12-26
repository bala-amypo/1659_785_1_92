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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // This class solves the "additionalProp" issue in Swagger
    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    @Operation(summary = "Login to get JWT Token")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());

        if (encoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
            
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("userId", user.getId());
            response.put("email", user.getEmail());
            response.put("role", user.getRole());
            return response;
        }
        throw new IllegalArgumentException("Invalid password");
    }
}