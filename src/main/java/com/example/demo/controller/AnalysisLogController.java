package com.example.demo.controller;

import com.example.demo.model.AnalysisLog;
import com.example.demo.service.AnalysisLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/logs")
@Tag(name = "Analysis Logs")
public class AnalysisLogController {

    private final AnalysisLogService logService;

    public AnalysisLogController(AnalysisLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{zoneId}")
    @Operation(summary = "Manually add an analysis log")
    public AnalysisLog addLog(@PathVariable Long zoneId, @RequestBody String message) {
        return logService.addLog(zoneId, message);
    }

    @GetMapping("/zone/{zoneId}")
    @Operation(summary = "Retrieve all logs for a specific zone")
    public List<AnalysisLog> getLogsByZone(@PathVariable Long zoneId) {
        return logService.getLogsByZone(zoneId);
    }
}