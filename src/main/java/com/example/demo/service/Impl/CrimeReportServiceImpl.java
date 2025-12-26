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

    public CrimeReportServiceImpl(CrimeReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        if (report.getLatitude() < -90 || report.getLatitude() > 90) 
            throw new IllegalArgumentException("Invalid latitude");
        if (report.getLongitude() < -180 || report.getLongitude() > 180) 
            throw new IllegalArgumentException("Invalid longitude");
        if (report.getOccurredAt() != null && report.getOccurredAt().isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Time cannot be in future");
        
        return reportRepository.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return reportRepository.findAll();
    }
}