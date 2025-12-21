package com.example.demo.service;

import com.example.demo.model.;
import java.util.List;

@Service
public interface PatternDetectionService{
       
       PatternDetectionResult detectPattern(Long zoneId);

       List<PatternDetectionResult>getResultsByZone(Long zoneId);


}