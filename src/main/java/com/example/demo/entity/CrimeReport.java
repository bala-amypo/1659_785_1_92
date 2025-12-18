package com.example.demo.entity;

import java.time.LocalDateTime;

public class CrimeReport {
    
        private Long id;
        private String crimeType;
        private String description;
        private Double latitude;
        private Double longitude;
        private LocalDateTime occuredAt;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getCrimeType() {
            return crimeType;
        }
        public void setCrimeType(String crimeType) {
            this.crimeType = crimeType;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Double getLatitude() {
            return latitude;
        }
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }
        public Double getLongitude() {
            return longitude;
        }
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
        public LocalDateTime getOccuredAt() {
            return occuredAt;
        }
        public void setOccuredAt(LocalDateTime occuredAt) {
            this.occuredAt = occuredAt;
        }
        public CrimeReport() {
        }
        public CrimeReport(Long id, String crimeType, String description, Double latitude, Double longitude,
                LocalDateTime occuredAt) {
            this.id = id;
            this.crimeType = crimeType;
            this.description = description;
            this.latitude = latitude;
            this.longitude = longitude;
            this.occuredAt = occuredAt;
        }
    


}
