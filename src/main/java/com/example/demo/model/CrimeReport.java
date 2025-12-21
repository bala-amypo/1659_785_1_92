package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrimeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Crime type is mandatory")
    private String crimeType;

    @NotNull(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Latitude is mandatory")
    
    private Double latitude;

    @NotNull(message = "Longitude is mandatory")

    private Double longitude;

    @NotNull(message = "Occurred time is mandatory")
    @PastOrPresent(message = "Occurred time cannot be in the future")
    
    private LocalDateTime occurredAt;
}
