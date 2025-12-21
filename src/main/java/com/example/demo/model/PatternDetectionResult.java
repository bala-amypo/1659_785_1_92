package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
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
    private void setDetectedPattern() {
        if (crimeCount > 5) {
            detectedPattern = "High";
        } else if (crimeCount > 0) {
            detectedPattern = "Medium";
        } else {
            detectedPattern = "No";
        }
    }

    
}
