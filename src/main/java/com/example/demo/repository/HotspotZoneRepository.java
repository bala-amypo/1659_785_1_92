// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import  com.example.demo.model.HotspotZone;
// import org.springframework.stereotype.Repository;
// @Repository
// public interface HotspotZoneRepository extends JpaRepository<HotspotZone,Long>{
    
// }

package com.example.demo.repository;

import com.example.demo.model.HotspotZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotspotZoneRepository extends JpaRepository<HotspotZone, Long> {
    List<HotspotZone> findBySeverityLevel(String level);
    Optional<HotspotZone> findByZoneName(String zoneName);
    boolean existsByZoneName(String zoneName);
}