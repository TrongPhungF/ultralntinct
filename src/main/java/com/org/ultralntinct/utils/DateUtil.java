package com.org.ultralntinct.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * The Class DateUtil.
 * </p>
 *
 * @author MinhNgoc
 */
public class DateUtil {

    /** The Constant DATE_TIME_PATTERN. */
    public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * *
     * <p>
     * The method Convert pattern local date time to string.
     * </p>
     *
     * @author MinhNgoc
     * @param dateTime the date time
     * @param pattern  the pattern
     * @return the string
     */
    public static String convertPatternLocalDateTimeToString(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return dateTime.format(formatter);
    }

    /**
     * Instantiates a new date util.
     */
    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }
}
