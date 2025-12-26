package com.example.demo.service;
import com.example.demo.model.AnalysisLog;


public interface AnalysisLogService{


    AnalysisLog addLog(Long zoneId,String message);

    List<AnalysisLog>getLogsByZone(Long zoneId);
}


