package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.demo.model.HotspotZone;
import org.springframework.stereotype.Repository;
@Repository
public interface HotspotZoneRepository extends JpaRepository<HotspotZone,Long>{
    
}