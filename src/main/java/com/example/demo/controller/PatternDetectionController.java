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

