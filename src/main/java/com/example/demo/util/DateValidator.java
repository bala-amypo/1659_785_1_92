package com.example.demo.util;

import java.time.LocalDateTime;

public class DateValidator {
    
    public static boolean isNotFuture(LocalDateTime dateTime) {
        return dateTime != null && !dateTime.isAfter(LocalDateTime.now());
    }
}