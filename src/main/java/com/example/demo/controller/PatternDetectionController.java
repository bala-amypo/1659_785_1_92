package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PatternDetectionResult> detectPattern(
            @PathVariable Long zoneId) {

        PatternDetectionResult result =
                patternService.detectPatternForZone(zoneId);

        return ResponseEntity.ok(result);
    }

    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<PatternDetectionResult>> getResultsByZone(
            @PathVariable Long zoneId) {

        return ResponseEntity.ok(
                patternService.getResultsByZone(zoneId));
    }
}

