package com.automation.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(

    @JsonProperty("access_token")
    String accessToken,

    @JsonProperty("token_type")
    String tokenType,

    @JsonProperty("expires_in")
    String expiresIn,

    @JsonProperty("refresh_token")
    String refreshToken
) {
}
