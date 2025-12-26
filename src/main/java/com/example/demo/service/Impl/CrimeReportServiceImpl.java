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
import com.example.demo.util.CoordinateValidator;
import com.example.demo.util.DateValidator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {

    private final CrimeReportRepository reportRepository;
    private final CoordinateValidator coordinateValidator;
    private final DateValidator dateValidator;

    public CrimeReportServiceImpl(CrimeReportRepository reportRepository, 
                                  CoordinateValidator coordinateValidator, 
                                  DateValidator dateValidator) {
        this.reportRepository = reportRepository;
        this.coordinateValidator = coordinateValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public CrimeReport addReport(CrimeReport report) {
        // Use Utils for validation
        coordinateValidator.validate(report.getLatitude(), report.getLongitude());
        dateValidator.validateNotFuture(report.getOccurredAt());
        
        return reportRepository.save(report);
    }

    @Override
    public List<CrimeReport> getAllReports() {
        return reportRepository.findAll();
    }
}