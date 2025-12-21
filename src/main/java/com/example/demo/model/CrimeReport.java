// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// import java.time.LocalDateTime;

// @Entity
// public class CrimeReport {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String crimeType;

//     private String description;

   
//     private Double latitude;

  
//     private Double longitude;

   
//     private LocalDateTime occurredAt;

//     public CrimeReport() {
//     }

//     public CrimeReport(String crimeType, String description, Double latitude, Double longitude, LocalDateTime occurredAt) {
//         this.crimeType = crimeType;
//         this.description = description;
//         this.latitude = latitude;
//         this.longitude = longitude;
//         this.occurredAt = occurredAt;
//     }

//     public Long getId() {
//         return id;
//     }
//     public String getCrimeType() {
//         return crimeType;
//     }
//     public void setCrimeType(String crimeType) {
//         this.crimeType = crimeType;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public void setDescription(String description) {
//         this.description = description;
//     }
//     public Double getLatitude() {
//         return latitude;
//     }
//     public void setLatitude(Double latitude) {
//         this.latitude = latitude;
//     }
//     public Double getLongitude() {
//         return longitude;
//     }
//     public void setLongitude(Double longitude) {
//         this.longitude = longitude;
//     }
//     public LocalDateTime getOccurredAt() {
//         return occurredAt;
//     }
//     public void setOccurredAt(LocalDateTime occurredAt) {
//         this.occurredAt = occurredAt;
//     }
// }
