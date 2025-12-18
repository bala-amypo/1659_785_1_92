package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PatternDetectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private HotspotZone zone;

    private LocalDate analysisDate;
    private Integer crimeCount;
    private String detectedPattern;

    public PatternDetectionResult() {
    }

    public PatternDetectionResult(Long id,HotspotZone zone, LocalDate analysisDate, Integer crimeCount, String detectedPattern) {
        this.id=id;
        this.zone = zone;
        this.analysisDate = analysisDate;
        this.crimeCount = crimeCount;
        this.detectedPattern = detectedPattern;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public HotspotZone getZone() {
        return zone;
    }

    public void setZone(HotspotZone zone) {
        this.zone = zone;
    }

    public LocalDate getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(LocalDate analysisDate) {
        this.analysisDate = analysisDate;
    }

    public Integer getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(Integer crimeCount) {
        this.crimeCount = crimeCount;
    }

    public String getDetectedPattern() {
        return detectedPattern;
    }

    public void setDetectedPattern(String detectedPattern) {
        this.detectedPattern = detectedPattern;
    }
}
