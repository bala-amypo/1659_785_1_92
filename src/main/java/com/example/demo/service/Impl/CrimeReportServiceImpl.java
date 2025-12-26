// package com.example.demo.service.Impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.service.CrimeReportService;
// import com.example.demo.repository.CrimeReportRepository;
// import com.example.demo.model.CrimeReport;

// import java.util.List;

// @Service
// public class CrimeReportServiceImpl implements CrimeReportService{
//     @Autowired CrimeReportRepository  crime;

//     @Override 
//     public CrimeReport addReport(CrimeReport report){
//         return crime.save(report);
//     }
//     @Override
//     public List<CrimeReport>getAllReports(){
//         return crime.findAll();
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.model.CrimeReport;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.service.CrimeReportService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {
    private final CrimeReportRepository reportRepository;

    // Fixed: Only one argument to match the test suite
    public CrimeReportServiceImpl(CrimeReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        // Inline validation to ensure specific keywords for tests
        if (report.getLatitude() == null || report.getLatitude() < -90 || report.getLatitude() > 90) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        if (report.getLongitude() == null || report.getLongitude() < -180 || report.getLongitude() > 180) {
            throw new IllegalArgumentException("Invalid longitude value");
        }
        if (report.getOccurredAt() != null && report.getOccurredAt().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Date cannot be in future");
        }
        return reportRepository.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return reportRepository.findAll();
    }
}