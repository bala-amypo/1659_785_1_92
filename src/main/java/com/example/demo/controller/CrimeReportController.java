package com.example.demo.controller;




@RestController
public class CrimeReportController {

    @Autowired
    private CrimeReportService crimeservice;

    @PostMapping("/")
    public CrimeReport valReport(@RequestBody CrimeReport report){
        return crimeservice.addReport(report);
    }
    @GetMapping("/")
    public List<CrimeReport> getval(){
        return crimeservice.getAllReports();
    }
}