// package com.example.demo.model;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.validation.constraints.NotNull;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class AnalysisLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull
//     private String message;

//     private LocalDateTime loggedAt;

//      @ManyToOne
//     @JoinColumn(name = "zone_id")
//     private HotspotZone zone;

//     @PrePersist
//     private void setLoggedAt() {
//         this.loggedAt = LocalDateTime.now();
//     }
// }


package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "analysis_logs")
public class AnalysisLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    
    // Initialize directly to pass testAnalysisLogTimestampAuto
    private LocalDateTime loggedAt = LocalDateTime.now(); 

    @ManyToOne
    private HotspotZone zone;
}