package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotNull
    private HotspotZone zone;

    @NotNull
    private LocalDate analysisDate;

    @NotNull
    @Min(value = 0, message = "Crime count must be zero or positive")
    private Integer crimeCount;

    
    private String detectedPattern;

    @PrePersist
    @PreUpdate
    private void applyRules() {

        
        if (analysisDate == null) {
            analysisDate = LocalDate.now();
        }

        
        if (crimeCount != null && crimeCount > 5) {
            detectedPattern = "High crime density";
        } else if (crimeCount != null && crimeCount > 0) {
            detectedPattern = "Medium crime density";
        } else {
            detectedPattern = "No crime detected";
        }
    }
}
