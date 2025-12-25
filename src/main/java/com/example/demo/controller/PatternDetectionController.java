package com.example.demo.controller;

import java.util.List;

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

    private final PatternDetectionService service;

    public PatternDetectionController(PatternDetectionService service) {
        this.service = service;
    }

    @PostMapping("/detect/{zoneId}")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return service.detectPattern(zoneId);
    }

    @GetMapping("/zone/{zoneId}")
    public List<PatternDetectionResult> getByZone(@PathVariable Long zoneId) {
        return service.getResultsByZone(zoneId);
    }
}
