package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.HotspotZoneService;
import com.example.demo.repository.HotspotZoneRepository;
import com.example.demo.model.HotspotZone;

import java.util.List;

@Service
public class HotspotZoneServiceImpl implements HotspotZoneService{
    @Autowired HotspotZoneRepository  hotspot;

    @Override 
    public HotspotZone addZone(HotspotZone zone){
        return hotspot.save(zone);
    }
    @Override
    public List<HotspotZone>getAllZones(){
        return hotspot.findAll();
    }
}