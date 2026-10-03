package com.automation.core.config;

public final class ConfigKeys {

    private ConfigKeys(){}

    public static final String EXECUTION_TYPE = "execution.type";

    // UI
    public static final String BASE_URL = "base.url";
    public static final String BROWSER = "browser";
    public static final String HEADLESS = "headless";

    // API
    public static final String API_BASE_URL = "api.base.url";
    public static final String API_BASE_PATH = "api.base.path";

    public static final String API_AUTH_TYPE = "api.auth.type";
    public static final String API_AUTH_TOKEN_URL = "api.auth.token.url";

    public static final String API_CONNECTION_TIMEOUT = "api.connection.timeout.seconds";
    public static final String API_RESPONSE_TIMEOUT = "api.response.timeout.seconds";
    public static final String API_REQUEST_TIMEOUT = "api.request.timeout.seconds";
}
