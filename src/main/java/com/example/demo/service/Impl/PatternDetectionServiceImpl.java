// package com.example.demo.service.Impl;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.HotspotZone;
// import com.example.demo.model.PatternDetectionResult;
// import com.example.demo.repository.CrimeReportRepository;
// import com.example.demo.repository.HotspotZoneRepository;
// import com.example.demo.repository.PatternDetectionResultRepository;
// import com.example.demo.service.PatternDetectionService;

// @Service
// public class PatternDetectionServiceImpl implements PatternDetectionService {

//     @Autowired
//     private HotspotZoneRepository hotspotZoneRepository;

//     @Autowired
//     private CrimeReportRepository crimeReportRepository;

//     @Autowired
//     private PatternDetectionResultRepository patternResultRepository;

//     @Override
//     public PatternDetectionResult detectPattern(Long zoneId) {

//         HotspotZone zone = hotspotZoneRepository.findById(zoneId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("zone not found"));

      
//         double minLat = zone.getCenterLat() - 0.1;
//         double maxLat = zone.getCenterLat() + 0.1;
//         double minLong = zone.getCenterLong() - 0.1;
//         double maxLong = zone.getCenterLong() + 0.1;

//         List<?> crimes = crimeReportRepository
//                 .findByLatitudeBetweenAndLongitudeBetween(
//                         minLat, maxLat, minLong, maxLong);

       
//         int crimeCount = crimes.size();

      
//         String pattern;
//         String severity;

//         if (crimeCount > 5) {
//             pattern = "High crime activity detected";
//             severity = "HIGH";
//         } else if (crimeCount > 0) {
//             pattern = "Medium crime activity detected";
//             severity = "MEDIUM";
//         } else {
//             pattern = "No crime detected";
//             severity = "LOW";
//         }

       
//         PatternDetectionResult result = new PatternDetectionResult();
//         result.setZoneId(zoneId);
//         result.setAnalysisDate(LocalDate.now());
//         result.setCrimeCount(crimeCount);
//         // result.setDetectedPattern(pattern);

//         patternResultRepository.save(result);

       
//         zone.setSeverityLevel(severity);
//         hotspotZoneRepository.save(zone);

//         return result;
//     }

//     @Override
//     public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
//         return patternResultRepository.findByZoneId(zoneId);
//     }
// }
