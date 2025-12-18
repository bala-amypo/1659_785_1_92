// package com.example.demo.model;



// public class User{
//     private Long id;
//     private String name;
//     private String email;
//     private String password;
//     private String role;
//     private LocalDateTime createdAt;

//     public User(Long id,String name, String email,String password, String role, String createdAt){
//         this.id=id;
//         this.name=name;
//         this.email=email;
//         this.password=password;
//         this.role=role;
//         this.createdAt=createdAt;
//     }

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//      public String getName(){
//         return name;
//     }
//     public void setName(String name){
//         this.name=name;
//     }
//      public String getEmail(){
//         return email;
//     }
//     public void setEmail(String email){
//         this.email=email;
//     }
//      public String getPassword(){
//         return password;
//     }
//     public void setPassword(String password){
//         this.password=password;
//     }
//     public LocalDateTime getCreatedAt(){
//         return createdAt;
//     }
//     public void setCreatedAt(LocalDateTime createdAt){
//         this.createdAt=createdAt;
//     }
// }



package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;

    private LocalDateTime createdAt;

    // 🔹 No-arg constructor
    public User() {
        // default role
        this.role = "ANALYST";
    }

    // 🔹 Parameterized constructor
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = (role == null || role.isEmpty()) ? "ANALYST" : role;
    }

    // 🔹 Set createdAt automatically before insert
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = (role == null || role.isEmpty()) ? "ANALYST" : role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
