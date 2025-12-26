package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AnalysisLogController {
    
    @Autowired
    private AnalysisLogService analysisLogService;
    
    @PostMapping("/{zoneId}")
    public ResponseEntity<?> addLog(@PathVariable Long zoneId, @RequestBody String message) {
        try {
            AnalysisLog log = analysisLogService.addLog(zoneId, message);
            return ResponseEntity.ok(log);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<AnalysisLog>> getLogsByZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(analysisLogService.getLogsByZone(zoneId));
    }
}