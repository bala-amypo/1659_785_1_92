package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;


@RestController
@RequestMapping("/patterns")
public class PatternDetectionController {

    @Autowired
    private PatternDetectionService patternService;

    
    @PostMapping("/detect/{zoneId}")
    public PatternDetectionResult detectPattern(
            @PathVariable Long zoneId) {

        return patternService.detectPatternForZone(zoneId);
    }

    
    @GetMapping("/zone/{zoneId}")
    public List<PatternDetectionResult> getResultsByZone(
            @PathVariable Long zoneId) {

        return patternService.getResultsByZone(zoneId);
    }
}
