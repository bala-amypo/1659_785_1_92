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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/zones")
@Tag(name = "Hotspot Zones")
public class HotspotZoneController {

    private final HotspotZoneService zoneService;

    public HotspotZoneController(HotspotZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @PostMapping
    @Operation(summary = "Create a hotspot zone")
    public HotspotZone createZone(@RequestBody HotspotZone zone) {
        return zoneService.addZone(zone);
    }

    @GetMapping
    @Operation(summary = "List all hotspot zones")
    public List<HotspotZone> getAllZones() {
        return zoneService.getAllZones();
    }
}