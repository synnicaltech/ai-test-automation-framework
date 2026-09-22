package com.automation.services;

import com.automation.core.exception.FrameworkException;
import com.automation.utils.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotService {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotService.class);

    private final WebDriver driver;

    public ScreenshotService(WebDriver driver) {
        if (driver == null) {
            throw new FrameworkException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    public Path capture(String name, String reason) {
        if(name == null || name.isBlank()){
            name = "screenshot";
        }
        try {
            String threadName = Thread.currentThread().getName();
            Path directory = Path.of("build", "screenshots", sanitizeFileName(threadName));
            Files.createDirectories(directory);
            String fileName = sanitizeFileName(name) + "_"+sanitizeFileName(reason)+"_"+ DateUtils.now() + ".png";
            Path destination = directory.resolve(fileName);
            log.info("Capturing screenshot: {}", destination);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(destination, screenshot);
            log.info("Screenshot saved: {}", destination);
            return destination;
        } catch (IOException e) {
            log.error("Failed to save screenshot", e);
            throw new FrameworkException("Failed to capture screenshot.", e);
        }
    }

    private String sanitizeFileName(String name) {
        return name.replaceAll("[^a-zA-Z0-9._-]", "_");
    }
}
