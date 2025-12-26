// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import jakarta.validation.Valid;
// import com.example.demo.model.HotspotZone;
// import com.example.demo.service.HotspotZoneService;

// @RestController
// public class HotspotZoneController {

//     @Autowired
//     private HotspotZoneService hotservice;

//     @PostMapping("/hotpost")
//     public HotspotZone hotReport(@Valid @RequestBody HotspotZone zone ){
//         return hotservice.addZone(zone);
//     }
//     @GetMapping("/hotget")
//     public List<HotspotZone> hotval(){
//         return hotservice.getAllZones();
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.HotspotZone;
import com.example.demo.service.HotspotZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class HotspotZoneController {
    
    @Autowired
    private HotspotZoneService hotspotZoneService;
    
    @PostMapping
    public ResponseEntity<?> addZone(@RequestBody HotspotZone zone) {
        try {
            HotspotZone savedZone = hotspotZoneService.addZone(zone);
            return ResponseEntity.ok(savedZone);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<HotspotZone>> getAllZones() {
        return ResponseEntity.ok(hotspotZoneService.getAllZones());
    }
}