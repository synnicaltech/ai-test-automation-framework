package com.automation.services;

import com.automation.core.exception.FrameworkException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptService {

    private final JavascriptExecutor javascriptExecutor;

    public JavaScriptService(WebDriver driver) {
        if (driver == null) {
            throw new FrameworkException("WebDriver cannot be null.");
        }
        if (!(driver instanceof JavascriptExecutor)) {
            throw new FrameworkException("Driver does not support JavaScript execution.");
        }
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    public Object execute(String script, Object... arguments) {
        return javascriptExecutor.executeScript(script, arguments);
    }

    public void scrollToTop() {
        execute("window.scrollTo(0, 0);");
    }

    public void scrollToBottom() {
        execute("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollIntoView(WebElement element) {
        execute("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}
