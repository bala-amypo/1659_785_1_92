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