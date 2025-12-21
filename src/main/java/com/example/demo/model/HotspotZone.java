// package com.example.demo.model;



// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;


// @Entity
// public class HotspotZone {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String zoneName;
//     private Double centerLat;
//     private Double centerLong;
//     private String severityLevel;

//     public HotspotZone() {
//     }

//     public HotspotZone(String zoneName, Double centerLat, Double centerLong, String severityLevel) {
//         this.zoneName = zoneName;
//         this.centerLat = centerLat;
//         this.centerLong = centerLong;
//         this.severityLevel = severityLevel;
//     }

//     public Long getId() {
//         return id;
//     }

//     public String getZoneName() {
//         return zoneName;
//     }

//     public void setZoneName(String zoneName) {
//         this.zoneName = zoneName;
//     }

//     public Double getCenterLat() {
//         return centerLat;
//     }

//     public void setCenterLat(Double centerLat) {
//         this.centerLat = centerLat;
//     }

//     public Double getCenterLong() {
//         return centerLong;
//     }

//     public void setCenterLong(Double centerLong) {
//         this.centerLong = centerLong;
//     }

//     public String getSeverityLevel() {
//         return severityLevel;
//     }

//     public void setSeverityLevel(String severityLevel) {
//         this.severityLevel = severityLevel;
//     }
// }
