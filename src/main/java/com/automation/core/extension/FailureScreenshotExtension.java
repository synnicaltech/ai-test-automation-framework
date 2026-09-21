package com.automation.core.extension;

import com.automation.core.driver.DriverManager;
import com.automation.services.ScreenshotService;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class FailureScreenshotExtension implements AfterTestExecutionCallback {

    private static final Logger log = LoggerFactory.getLogger(FailureScreenshotExtension.class);

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if(!isTestFailed(context)){
            return;
        }

        String testName = context.getDisplayName();
        log.error("Test Failed. Capturing screenshot: {}", testName);

        try{
            if(!hasDriver()){
                log.warn("WebDriver not available. Screenshot can not be captured.");
                return;
            }
            ScreenshotService screenshotService = new ScreenshotService(DriverManager.getDriver());
            Path screenshot = screenshotService.capture(testName + "failure");
            log.info("Failure screenshot captured: {}", screenshot);
        } catch (Exception e) {
            log.error("Failed to capture failure screenshot", e);
        }
    }

    private boolean isTestFailed(ExtensionContext context){
        return context.getExecutionException().isPresent();
    }

    private boolean hasDriver(){
        try{
            DriverManager.getDriver();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
