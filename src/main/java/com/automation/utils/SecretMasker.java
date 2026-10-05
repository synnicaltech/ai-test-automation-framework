package com.automation.utils;

import java.util.Objects;

public final class SecretMasker {

    private static final String MASK = "********";

    private SecretMasker() {}

    public static String mask(String value) {
        if (value == null || value.isBlank()) {
            return value;
        }

        return MASK;
    }

    public static String maskBearerToken(String value) {
        if (value == null || value.isBlank()) {
            return value;
        }

        return "Bearer " + MASK;
    }

    public static String maskIfPresent(
            String key,
            String value) {

        if (value == null) {
            return null;
        }

        String normalizedKey = Objects.requireNonNullElse(key, "")
                .toLowerCase();

        if (normalizedKey.contains("authorization")
                || normalizedKey.contains("token")
                || normalizedKey.contains("password")
                || normalizedKey.contains("secret")
                || normalizedKey.contains("api-key")) {

            return MASK;
        }

        return value;
    }
}
