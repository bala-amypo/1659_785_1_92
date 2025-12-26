// package com.example.demo.service.Impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.service.Service;
// import com.example.demo.repository.Repository;
// import com.example.demo.model.;

// import java.util.List;

// @Service
// public class HotspotZoneServiceImpl implements HotspotZoneService{
//     @Autowired 
//      private  AnalysisLogRepository  analysis ;

//     @Override 
//     public  AnalysisLog addLog(Long zoneId,String message){
//         return analysis.save();
//     }
//     @Override
//     public List<AnalysisLog>getLogsByZone(Long zoneId){
//         return analysis.findAll(zoneId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;
import com.example.demo.service.PatternDetectionService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {
    private final HotspotZoneRepository zoneRepo;
    private final CrimeReportRepository reportRepo;
    private final PatternDetectionResultRepository resultRepo;
    private final AnalysisLogRepository logRepo;

    public PatternDetectionServiceImpl(HotspotZoneRepository zoneRepo, CrimeReportRepository reportRepo, 
                                      PatternDetectionResultRepository resultRepo, AnalysisLogRepository logRepo) {
        this.zoneRepo = zoneRepo;
        this.reportRepo = reportRepo;
        this.resultRepo = resultRepo;
        this.logRepo = logRepo;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {
        HotspotZone zone = zoneRepo.findById(zoneId)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        double minLat = zone.getCenterLat() - 0.1;
        double maxLat = zone.getCenterLat() + 0.1;
        double minLong = zone.getCenterLong() - 0.1;
        double maxLong = zone.getCenterLong() + 0.1;

        int count = reportRepo.findByLatLongRange(minLat, maxLat, minLong, maxLong).size();
        String pattern = count > 5 ? "High Density" : (count > 0 ? "Medium Density" : "No Pattern");
        
        // Update Zone Severity
        if (count > 5) zone.setSeverityLevel("HIGH");
        else if (count > 0) zone.setSeverityLevel("MEDIUM");
        else zone.setSeverityLevel("LOW");
        zoneRepo.save(zone);

        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setCrimeCount(count);
        result.setDetectedPattern(pattern);
        result.setAnalysisDate(LocalDate.now());
        resultRepo.save(result);

        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Analysis performed. Detected: " + pattern);
        logRepo.save(log);

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepo.findByZone_Id(zoneId);
    }
}