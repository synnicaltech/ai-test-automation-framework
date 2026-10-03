package com.automation.core.config;

import java.net.URI;
import java.time.Duration;
import java.util.Objects;

public final class ApiConfig {

    private final URI baseUrl;
    private final String basePath;
    private final String authType;
    private final String tokenUrl;
    private final Duration connectionTimeout;
    private final Duration responseTimeout;
    private final Duration requestTimeout;

    public ApiConfig(
            URI baseUrl,
            String basePath,
            String authType,
            String tokenUrl,
            Duration connectionTimeout,
            Duration responseTimeout,
            Duration requestTimeout){
        this.baseUrl = Objects.requireNonNull(baseUrl, "API base URL must not be null");
        this.basePath = normalizePath(basePath);
        this.authType = requireNonBlank(authType, "API auth type");
        this.tokenUrl = normalizePath(tokenUrl);
        this.connectionTimeout = requirePositive(connectionTimeout, "Connection timeout");
        this.responseTimeout = requirePositive(responseTimeout, "Response timeout");
        this.requestTimeout = requirePositive(requestTimeout, "Request timeout");
        validateBaseUrl();
    }

    public URI getBaseUrl(){
        return baseUrl;
    }

    public String getBasePath(){
        return basePath;
    }

    public String getAuthType(){
        return authType;
    }

    public String getTokenUrl(){
        return tokenUrl;
    }

    public Duration getConnectionTimeout(){
        return connectionTimeout;
    }

    public Duration getResponseTimeout(){
        return responseTimeout;
    }

    public Duration getRequestTimeout(){
        return requestTimeout;
    }

    private void validateBaseUrl(){
        String schema = baseUrl.getScheme();

        if(!"http".equalsIgnoreCase(schema) && !"https".equalsIgnoreCase(schema)){
            throw new IllegalArgumentException("API base URL must use HTTP or HTTPS: "+baseUrl);
        }
    }

    private String normalizePath(String value){
        if(value == null || value.isBlank()){
            return "";
        }
        return value.startsWith("/") ? value : "/" + value;
    }

    private String requireNonBlank(String value, String fieldName){
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }

        return value.trim();
    }

    private Duration requirePositive(Duration value, String fieldName) {
        Objects.requireNonNull(value, fieldName + " must not be null");

        if (value.isZero() || value.isNegative()) {
            throw new IllegalArgumentException(
                    fieldName + " must be greater than zero");
        }

        return value;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "baseUrl=" + baseUrl +
                ", basePath='" + basePath + '\'' +
                ", authType='" + authType + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                ", connectionTimeout=" + connectionTimeout +
                ", responseTimeout=" + responseTimeout +
                ", requestTimeout=" + requestTimeout +
                '}';
    }
}
