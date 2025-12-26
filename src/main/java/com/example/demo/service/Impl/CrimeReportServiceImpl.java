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
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {
    
    private final CrimeReportRepository crimeReportRepository;
    
    public CrimeReportServiceImpl(CrimeReportRepository crimeReportRepository) {
        this.crimeReportRepository = crimeReportRepository;
    }
    
    @Override
    public CrimeReport addReport(CrimeReport report) {
        if (report.getLatitude() == null || report.getLatitude() < -90 || report.getLatitude() > 90) {
            throw new RuntimeException("Invalid latitude");
        }
        if (report.getLongitude() == null || report.getLongitude() < -180 || report.getLongitude() > 180) {
            throw new RuntimeException("Invalid longitude");
        }
        return crimeReportRepository.save(report);
    }
    
    @Override
    public List<CrimeReport> getAllReports() {
        return crimeReportRepository.findAll();
    }
}

