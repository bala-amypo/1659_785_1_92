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
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService {
    
    private final HotspotZoneRepository hotspotZoneRepository;
    
    public HotspotZoneServiceImpl(HotspotZoneRepository hotspotZoneRepository) {
        this.hotspotZoneRepository = hotspotZoneRepository;
    }
    
    @Override
    public HotspotZone addZone(HotspotZone zone) {
        if (hotspotZoneRepository.existsByZoneName(zone.getZoneName())) {
            throw new RuntimeException("Zone already exists with this name");
        }
        if (zone.getCenterLat() == null || zone.getCenterLat() < -90 || zone.getCenterLat() > 90) {
            throw new RuntimeException("Invalid latitude");
        }
        if (zone.getCenterLong() == null || zone.getCenterLong() < -180 || zone.getCenterLong() > 180) {
            throw new RuntimeException("Invalid longitude");
        }
        return hotspotZoneRepository.save(zone);
    }
    
    @Override
    public List<HotspotZone> getAllZones() {
        return hotspotZoneRepository.findAll();
    }
}


