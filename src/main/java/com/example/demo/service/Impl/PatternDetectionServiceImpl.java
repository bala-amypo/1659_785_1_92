// package com.example.demo.service;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.AnalysisLog;
// import com.example.demo.model.CrimeReport;
// import com.example.demo.model.HotspotZone;
// import com.example.demo.model.PatternDetectionResult;
// import com.example.demo.repository.AnalysisLogRepository;
// import com.example.demo.repository.CrimeReportRepository;
// import com.example.demo.repository.HotspotZoneRepository;
// import com.example.demo.repository.PatternDetectionResultRepository;

// @Service
// public class PatternDetectionServiceImpl implements PatternDetectionService {

//     private final HotspotZoneRepository zoneRepository;
//     private final CrimeReportRepository crimeRepository;
//     private final PatternDetectionResultRepository resultRepository;
//     private final AnalysisLogRepository logRepository;

  
//     public PatternDetectionServiceImpl(
//             HotspotZoneRepository zoneRepository,
//             CrimeReportRepository crimeRepository,
//             PatternDetectionResultRepository resultRepository,
//             AnalysisLogRepository logRepository) {

//         this.zoneRepository = zoneRepository;
//         this.crimeRepository = crimeRepository;
//         this.resultRepository = resultRepository;
//         this.logRepository = logRepository;
//     }

//     @Override
//     public PatternDetectionResult detectPattern(Long zoneId) {

       
//         HotspotZone zone = zoneRepository.findById(zoneId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Zone not found"));
       
//         double minLat = zone.getCenterLat() - 0.1;
//         double maxLat = zone.getCenterLat() + 0.1;
//         double minLong = zone.getCenterLong() - 0.1;
//         double maxLong = zone.getCenterLong() + 0.1;

//         List<CrimeReport> crimes =
//                 crimeRepository.findByLatLongRange(
//                         minLat, maxLat, minLong, maxLong);

     
//         int crimeCount = crimes.size();

    
//         String detectedPattern;

//         if (crimeCount > 5) {
//             detectedPattern = "High crime density detected";
//         } else if (crimeCount > 0) {
//             detectedPattern = "Medium crime density detected";
//         } else {
//             detectedPattern = "No crime detected";
//         }

        
//         PatternDetectionResult result = new PatternDetectionResult();
//         result.setZone(zone);
//         result.setAnalysisDate(LocalDate.now());
//         result.setCrimeCount(crimeCount);
//         result.setDetectedPattern(detectedPattern);

//         resultRepository.save(result);

        
//         AnalysisLog log = new AnalysisLog();
//         log.setZone(zone);
//         log.setMessage("Pattern analysis completed for zone");

//         logRepository.save(log);

//         if (crimeCount > 5) {
//             zone.setSeverityLevel("HIGH");
//         } else if (crimeCount > 0) {
//             zone.setSeverityLevel("MEDIUM");
//         } else {
//             zone.setSeverityLevel("LOW");
//         }

//         zoneRepository.save(zone);

//         return result;
//     }

//     @Override
//     public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
//         return resultRepository.findByZone_Id(zoneId);
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.model.CrimeReport;
import com.example.demo.model.AnalysisLog;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {
    
    private final HotspotZoneRepository zoneRepository;
    private final CrimeReportRepository reportRepository;
    private final PatternDetectionResultRepository resultRepository;
    private final AnalysisLogRepository logRepository;
    
    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepository, 
                                     CrimeReportRepository reportRepository,
                                     PatternDetectionResultRepository resultRepository,
                                     AnalysisLogRepository logRepository) {
        this.zoneRepository = zoneRepository;
        this.reportRepository = reportRepository;
        this.resultRepository = resultRepository;
        this.logRepository = logRepository;
    }
    
    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepository.findById(zoneId)
            .orElseThrow(() -> new RuntimeException("Zone not found"));
        
        double radius = 0.1;
        List<CrimeReport> reports = reportRepository.findByLatLongRange(
            zone.getCenterLat() - radius, zone.getCenterLat() + radius,
            zone.getCenterLong() - radius, zone.getCenterLong() + radius
        );
        
        int crimeCount = reports.size();
        String pattern;
        String severity;
        
        if (crimeCount > 5) {
            pattern = "High crime pattern detected";
            severity = "HIGH";
        } else if (crimeCount > 0) {
            pattern = "Medium crime pattern detected";
            severity = "MEDIUM";
        } else {
            pattern = "No significant pattern detected";
            severity = "LOW";
        }
        
        zone.setSeverityLevel(severity);
        zoneRepository.save(zone);
        
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setDetectedPattern(pattern);
        result.setCrimeCount(crimeCount);
        result.setAnalysisDate(LocalDate.now());
        
        PatternDetectionResult savedResult = resultRepository.save(result);
        
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern detection completed for zone: " + zone.getZoneName());
        log.setLoggedAt(LocalDateTime.now());
        logRepository.save(log);
        
        return savedResult;
    }
    
    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepository.findByZone_Id(zoneId);
    }
}
