package com.example.demo.util;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DateValidator {
    public void validateNotFuture(LocalDateTime dateTime) {
        if (dateTime != null && dateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Occurred time cannot be in the future");
        }
    }
}