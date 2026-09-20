package com.automation.services;

import com.automation.core.exception.FrameworkException;
import com.automation.utils.DateUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotService {

    private final WebDriver driver;

    public ScreenshotService(WebDriver driver) {
        if (driver == null) {
            throw new FrameworkException("WebDriver cannot be null.");
        }
        this.driver = driver;
    }

    public Path capture(String name) {
        try {
            Path directory = Path.of("build", "screenshots");
            Files.createDirectories(directory);
            String fileName = name + "_" + DateUtils.now() + ".png";
            Path destination = directory.resolve(fileName);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(destination, screenshot);
            return destination;
        } catch (IOException e) {
            throw new FrameworkException("Failed to capture screenshot.", e);
        }
    }
}
