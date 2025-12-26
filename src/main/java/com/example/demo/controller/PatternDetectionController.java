// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.demo.model.PatternDetectionResult;
// import com.example.demo.service.PatternDetectionService;

// @RestController
// @RequestMapping("/patterns")
// public class PatternDetectionController {

//     private final PatternDetectionService service;

//     public PatternDetectionController(PatternDetectionService service) {
//         this.service = service;
//     }

//     @PostMapping("/detect/{zoneId}")
//     public PatternDetectionResult detect(@PathVariable Long zoneId) {
//         return service.detectPattern(zoneId);
//     }

//     @GetMapping("/zone/{zoneId}")
//     public List<PatternDetectionResult> getByZone(@PathVariable Long zoneId) {
//         return service.getResultsByZone(zoneId);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.PatternDetectionResult;
import com.example.demo.service.PatternDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patterns")
public class PatternDetectionController {
    
    @Autowired
    private PatternDetectionService patternDetectionService;
    
    @PostMapping("/detect/{zoneId}")
    public ResponseEntity<?> detectPattern(@PathVariable Long zoneId) {
        try {
            PatternDetectionResult result = patternDetectionService.detectPattern(zoneId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<PatternDetectionResult>> getResultsByZone(@PathVariable Long zoneId) {
        return ResponseEntity.ok(patternDetectionService.getResultsByZone(zoneId));
    }
}
