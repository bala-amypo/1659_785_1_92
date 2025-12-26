package com.example.demo.util;
import org.springframework.stereotype.Component;

@Component
public class CoordinateValidator {
    public boolean isValid(Double lat, Double lon) {
        return lat != null && lat >= -90 && lat <= 90 && lon != null && lon >= -180 && lon <= 180;
    }
}