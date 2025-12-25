package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AnalysisLog;
import com.example.demo.model.CrimeReport;
import com.example.demo.model.HotspotZone;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.repository.PatternDetectionResultRepository;

@Service
public class PatternDetectionServiceImpl implements PatternDetectionService {

    private final HotspotZoneRepository zoneRepository;
    private final CrimeReportRepository crimeRepository;
    private final PatternDetectionResultRepository resultRepository;
    private final AnalysisLogRepository logRepository;

    // ✅ Constructor Injection (MANDATORY as per constraint)
    public PatternDetectionServiceImpl(
            HotspotZoneRepository zoneRepository,
            CrimeReportRepository crimeRepository,
            PatternDetectionResultRepository resultRepository,
            AnalysisLogRepository logRepository) {

        this.zoneRepository = zoneRepository;
        this.crimeRepository = crimeRepository;
        this.resultRepository = resultRepository;
        this.logRepository = logRepository;
    }

    @Override
    public PatternDetectionResult detectPattern(Long zoneId) {

        // ================================
        // 1️⃣ FETCH ZONE (NOT FOUND VALIDATION)
        // ================================
        HotspotZone zone = zoneRepository.findById(zoneId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Zone not found"));
        // ✔ message contains "zone" and "not"

        // ================================
        // 2️⃣ FETCH CRIMES NEAR ZONE (+/- 0.1)
        // ================================
        double minLat = zone.getCenterLat() - 0.1;
        double maxLat = zone.getCenterLat() + 0.1;
        double minLong = zone.getCenterLong() - 0.1;
        double maxLong = zone.getCenterLong() + 0.1;

        List<CrimeReport> crimes =
                crimeRepository.findByLatLongRange(
                        minLat, maxLat, minLong, maxLong);

        // ================================
        // 3️⃣ COUNT CRIMES
        // ================================
        int crimeCount = crimes.size();

        // ================================
        // 4️⃣ PATTERN DETECTION LOGIC (EXACT)
        // ================================
        String detectedPattern;

        if (crimeCount > 5) {
            detectedPattern = "High crime density detected";
        } else if (crimeCount > 0) {
            detectedPattern = "Medium crime density detected";
        } else {
            detectedPattern = "No crime detected";
        }

        // ================================
        // 5️⃣ SAVE PATTERN DETECTION RESULT
        // ================================
        PatternDetectionResult result = new PatternDetectionResult();
        result.setZone(zone);
        result.setAnalysisDate(LocalDate.now());
        result.setCrimeCount(crimeCount);
        result.setDetectedPattern(detectedPattern);

        resultRepository.save(result);

        // ================================
        // 6️⃣ SAVE ANALYSIS LOG
        // ================================
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage("Pattern analysis completed for zone");

        logRepository.save(log);

        // ================================
        // 7️⃣ UPDATE ZONE SEVERITY (OPTIONAL)
        // ================================
        if (crimeCount > 5) {
            zone.setSeverityLevel("HIGH");
        } else if (crimeCount > 0) {
            zone.setSeverityLevel("MEDIUM");
        } else {
            zone.setSeverityLevel("LOW");
        }

        zoneRepository.save(zone);

        return result;
    }

    @Override
    public List<PatternDetectionResult> getResultsByZone(Long zoneId) {
        return resultRepository.findByZone_Id(zoneId);
    }
}
