package com.automation.utils;

import com.automation.core.exception.FrameworkException;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Path;

public final class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils() {}

    public static <T> T read(Path path, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(path.toFile(), type);
        } catch (Exception e) {
            throw new FrameworkException("Failed to read JSON file: " + path, e);
        }
    }

    public static String write(Object object) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (Exception e) {
            throw new FrameworkException("Failed to serialize object to JSON.", e);
        }
    }
}
