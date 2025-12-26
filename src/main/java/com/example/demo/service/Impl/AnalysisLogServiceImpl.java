// package com.example.demo.service.Impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.service.Service;
// import com.example.demo.repository.Repository;
// import com.example.demo.model.;

// import java.util.List;

// @Service
// public class HotspotZoneServiceImpl implements HotspotZoneService{
//     @Autowired 
//      private  AnalysisLogRepository  analysis ;

//     @Override 
//     public  AnalysisLog addLog(Long zoneId,String message){
//         return analysis.save();
//     }
//     @Override
//     public List<AnalysisLog>getLogsByZone(Long zoneId){
//         return analysis.findAll(zoneId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.AnalysisLog;
import com.example.demo.model.HotspotZone;
import com.example.demo.repository.AnalysisLogRepository;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.AnalysisLogService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalysisLogServiceImpl implements AnalysisLogService {
    
    private final AnalysisLogRepository analysisLogRepository;
    private final HotspotZoneRepository zoneRepository;
    
    public AnalysisLogServiceImpl(AnalysisLogRepository analysisLogRepository,
                                HotspotZoneRepository zoneRepository) {
        this.analysisLogRepository = analysisLogRepository;
        this.zoneRepository = zoneRepository;
    }
    
    @Override
    public AnalysisLog addLog(Long zoneId, String message) {
        HotspotZone zone = zoneRepository.findById(zoneId)
            .orElseThrow(() -> new RuntimeException("Zone not found"));
        
        AnalysisLog log = new AnalysisLog();
        log.setZone(zone);
        log.setMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        
        return analysisLogRepository.save(log);
    }
    
    @Override
    public List<AnalysisLog> getLogsByZone(Long zoneId) {
        return analysisLogRepository.findByZone_Id(zoneId);
    }
}