package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;

@RestController
public class HotspotZoneController {

    @Autowired
    private CrimeReportService crimeservice;

    @PostMapping("/hotpost")
    public CrimeReport valReport(@Valid @RequestBody CrimeReport report){
        return crimeservice.addReport(report);
    }
    @GetMapping("/get")
    public List<CrimeReport> getval(){
        return crimeservice.getAllReports();
    }
}