package com.automation.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd_HH-mm-ss";

    private DateUtils() {}

    public static String now() {
        return now(DEFAULT_PATTERN);
    }

    public static String now(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.now().format(formatter);
    }
}
