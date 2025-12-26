// package com.example.demo.controller;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.validation.Valid;

// import com.example.demo.model.CrimeReport;
// import com.example.demo.service.CrimeReportService;

// @RestController
// public class CrimeReportController {

//     @Autowired
//     private CrimeReportService crimeservice;

//     @PostMapping("/post")
//     public CrimeReport valReport(@Valid @RequestBody CrimeReport report){
//         return crimeservice.addReport(report);
//     }
//     @GetMapping("/get")
//     public List<CrimeReport> getval(){
//         return crimeservice.getAllReports();
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.CrimeReport;
import com.example.demo.service.CrimeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class CrimeReportController {
    
    @Autowired
    private CrimeReportService crimeReportService;
    
    @PostMapping
    public ResponseEntity<?> addReport(@RequestBody CrimeReport report) {
        try {
            CrimeReport savedReport = crimeReportService.addReport(report);
            return ResponseEntity.ok(savedReport);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<CrimeReport>> getAllReports() {
        return ResponseEntity.ok(crimeReportService.getAllReports());
    }
}