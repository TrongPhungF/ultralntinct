package com.org.ultralntinct.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    public static String convertPatternLocalDateTimeToString(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return dateTime.format(formatter);
    }

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }
}
