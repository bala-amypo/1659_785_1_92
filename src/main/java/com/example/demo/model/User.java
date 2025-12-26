package com.example.demo.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 10, message = "must be 2 to 10 character")
    private String name;

    @Email(message = "Email is not valid")
    private String email;

    @Size(min = 2, max = 10, message = "must be 2 to 10 character")
    @NotNull(message = "Password is mandatory")
    private String password;

    private String role;
     
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private HotspotZone zone;

    private LocalDateTime createdAt;

    
    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null || this.role.trim().isEmpty()) {
        this.role = "ANALYST";
    }
    }
    }
    