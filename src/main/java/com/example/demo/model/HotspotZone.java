// package com.example.demo.model;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;

// import jakarta.validation.constraints.NotNull;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class HotspotZone {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull(message = "Zone name is mandatory")
//     @Column(unique = true)
//     private String zoneName;

//     @NotNull(message = "Center latitude is mandatory")
//     private Double centerLat;

//     @NotNull(message = "Center longitude is mandatory")
//     private Double centerLong;

//     @Column(nullable = false)
//     private String severityLevel;

//     @PrePersist
//     private void setDefaultSeverity() {
//         if (this.severityLevel == null || this.severityLevel.trim().isEmpty()) {
//             this.severityLevel = "LOW";
//         }
//     }
// }


package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotspot_zones")
public class HotspotZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String zoneName;
    private Double centerLat;
    private Double centerLong;
    private String severityLevel; 
}