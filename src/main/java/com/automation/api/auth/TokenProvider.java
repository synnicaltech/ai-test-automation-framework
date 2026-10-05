package com.automation.api.auth;

public interface TokenProvider {

    String getAccessToken();

    void invalidate();
}
