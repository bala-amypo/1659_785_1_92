package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.CrimeReportService;
import com.example.demo.repository.CrimeReportRepository;
import com.example.demo.model.CrimeReport;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HService{
    @Autowired CrimeReportRepository  crime;

    @Override 
    public CrimeReport addReport(CrimeReport report){
        return crime.save(report);
    }
    @Override
    public List<CrimeReport>getAllReports(){
        return crime.findAll();
    }
}