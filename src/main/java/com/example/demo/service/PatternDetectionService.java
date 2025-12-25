package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PatternDetectionResult;

public interface PatternDetectionService {

    PatternDetectionResult detectPattern(Long zoneId);

    List<PatternDetectionResult> getResultsByZone(Long zoneId);
}
