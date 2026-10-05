package com.automation.core.config;

public final class ApiAuthConfig {

    private final String authType;
    private final String tokenUrl;
    private final boolean tokenCacheEnabled;
    private final int connectTimeoutSeconds;
    private final int readTimeoutSeconds;

    public ApiAuthConfig(
            String authType,
            String tokenUrl,
            boolean tokenCacheEnabled,
            int connectTimeoutSeconds,
            int readTimeoutSeconds) {

        this.authType = authType;
        this.tokenUrl = tokenUrl;
        this.tokenCacheEnabled = tokenCacheEnabled;
        this.connectTimeoutSeconds = connectTimeoutSeconds;
        this.readTimeoutSeconds = readTimeoutSeconds;
    }

    public String authType() {
        return authType;
    }

    public String tokenUrl() {
        return tokenUrl;
    }

    public boolean tokenCacheEnabled() {
        return tokenCacheEnabled;
    }

    public int connectTimeoutSeconds() {
        return connectTimeoutSeconds;
    }

    public int readTimeoutSeconds() {
        return readTimeoutSeconds;
    }
}
