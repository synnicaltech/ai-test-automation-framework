package com.automation.core.context;

public final class TestContext {

    private static final ThreadLocal<String> TEST_NAME = new ThreadLocal<>();

    private static final ThreadLocal<String> BROWSER = new ThreadLocal<>();

    private static final ThreadLocal<String> ENVIRONMENT = new ThreadLocal<>();

    private TestContext(){}

    public static void setTestName(String testName) {
        TEST_NAME.set(testName);
    }

    public static String getTestName() {
        return TEST_NAME.get();
    }

    public static void setBrowser(String browser) {
        BROWSER.set(browser);
    }

    public static String getBrowser() {return BROWSER.get();
    }

    public static void setEnvironment(String environment) {
        ENVIRONMENT.set(environment);
    }

    public static String getEnvironment() {
        return ENVIRONMENT.get();
    }

    public static void clear() {
        TEST_NAME.remove();
        BROWSER.remove();
        ENVIRONMENT.remove();
    }
}
