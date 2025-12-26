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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/patterns")
@Tag(name = "Pattern Detection")
public class PatternDetectionController {

    private final PatternDetectionService detectionService;

    public PatternDetectionController(PatternDetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @PostMapping("/detect/{zoneId}")
    @Operation(summary = "Analyze and detect patterns for a zone")
    public PatternDetectionResult detect(@PathVariable Long zoneId) {
        return detectionService.detectPattern(zoneId);
    }

    @GetMapping("/zone/{zoneId}")
    @Operation(summary = "Get all detection results for a zone")
    public List<PatternDetectionResult> getResults(@PathVariable Long zoneId) {
        return detectionService.getResultsByZone(zoneId);
    }
}