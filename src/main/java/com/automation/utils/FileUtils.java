package com.automation.utils;

import com.automation.core.exception.FrameworkException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {}

    public static String readFile(Path path) {
        log.debug("Reading file: {}", path);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            log.error("Failed to read file: {}", path, e);
            throw new FrameworkException("Failed to read file: " + path, e);
        }
    }

    public static void writeFile(Path path, String content) {
        log.debug("Writing file: {}", path);
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Files.writeString(path, content);
            log.info("File written successfully: {}", path);
        } catch (IOException e) {
            log.error("Failed to write file: {}", path, e);
            throw new FrameworkException("Failed to write file: " + path, e);
        }
    }

    public static boolean exists(Path path) {
        return Files.exists(path);
    }

    public static void createDirectories(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            log.error("Failed to create directory: {}", path, e);
            throw new FrameworkException("Failed to create directory: " + path, e);
        }
    }
}
