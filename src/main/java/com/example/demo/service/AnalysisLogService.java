package com.example.demo.service;



public interface AnalysisLogService{


    AnalysisLog addLog(Long zoneId,String message);

    List<AnalysisLog>getLogsByZone(Long zoneI)
}