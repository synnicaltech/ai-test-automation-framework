package com.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final Logger log = LoggerFactory.getLogger(RandomUtils.class);

    private RandomUtils() {}

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uniqueEmail() {
        return "user_" + uuid() + "@example.com";
    }

    public static String uniqueUsername() {
        return "user_" + uuid();
    }

    public static int randomInt(int min, int max) {
        if (min > max) {
            log.error("min cannot be greater than max.");
            throw new IllegalArgumentException("min cannot be greater than max");
        }
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
