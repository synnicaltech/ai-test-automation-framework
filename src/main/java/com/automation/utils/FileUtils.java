package com.automation.utils;

import com.automation.core.exception.FrameworkException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtils {

    private FileUtils() {}

    public static String readFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new FrameworkException("Failed to read file: " + path, e);
        }
    }

    public static void writeFile(Path path, String content) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Files.writeString(path, content);
        } catch (IOException e) {
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
            throw new FrameworkException("Failed to create directory: " + path, e);
        }
    }
}
