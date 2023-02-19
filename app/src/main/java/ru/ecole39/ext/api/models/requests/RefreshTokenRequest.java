package ru.ecole39.ext.api.models.requests;

import com.google.gson.annotations.SerializedName;

public class RefreshTokenRequest extends AuthRequestBase {
    @SerializedName("refresh_token") public String refreshToken;

    public RefreshTokenRequest(String systemId, String refreshToken) {
        super("refresh_token", systemId);
        this.refreshToken = refreshToken;
    }
}
