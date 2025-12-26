// package com.example.demo.service.Impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.service.HotspotZoneService;
// import com.example.demo.repository.HotspotZoneRepository;
// import com.example.demo.model.HotspotZone;


// import java.util.List;

// @Service
// public class HotspotZoneServiceImpl implements HotspotZoneService{
//     @Autowired HotspotZoneRepository  hotspot;

//     @Override 
//     public HotspotZone addZone(HotspotZone zone){
//         return hotspot.save(zone);
//     }
    


//     @Override
//     public List<HotspotZone>getAllZones(){
//         return hotspot.findAll();
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.model.HotspotZone;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.service.HotspotZoneService;
import com.example.demo.util.CoordinateValidator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {

    private final HotspotZoneRepository zoneRepository;
    private final CoordinateValidator coordinateValidator;

    public HotspotZoneServiceImpl(HotspotZoneRepository zoneRepository, 
                                  CoordinateValidator coordinateValidator) {
        this.zoneRepository = zoneRepository;
        this.coordinateValidator = coordinateValidator;
    }

    @Override
    public HotspotZone addZone(HotspotZone zone) {
        if (zoneRepository.existsByZoneName(zone.getZoneName())) {
            // Requirement: Message must contain "exists"
            throw new IllegalArgumentException("Zone name already exists");
        }
        // Use Utils for validation
        coordinateValidator.validate(zone.getCenterLat(), zone.getCenterLong());
        
        return zoneRepository.save(zone);
    }

    @Override
    public List<HotspotZone> getAllZones() {
        return zoneRepository.findAll();
    }
}