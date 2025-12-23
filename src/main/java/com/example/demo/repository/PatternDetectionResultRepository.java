package com.example.demo.repository;

import  com.example.demo.model.PatternDetectionResult;
import org.springframework.stereotype.Repository;
@Repository
public interface PatternDetectionResultRepository extends JpaRepository<PatternDetectionResult,Long>{
    List<PatternDetectionResult> findByZone_Id(Long zoneId);
}