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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/reports")
@Tag(name = "Crime Reports")
public class CrimeReportController {

    private final CrimeReportService crimeReportService;

    public CrimeReportController(CrimeReportService crimeReportService) {
        this.crimeReportService = crimeReportService;
    }

    @PostMapping
    @Operation(summary = "Create a new crime report")
    public CrimeReport createReport(@RequestBody CrimeReport report) {
        return crimeReportService.addReport(report);
    }

    @GetMapping
    @Operation(summary = "Get all crime reports")
    public List<CrimeReport> getAllReports() {
        return crimeReportService.getAllReports();
    }
}