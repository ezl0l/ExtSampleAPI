package ru.ecole39.ext.api.models.responses;

import com.google.gson.annotations.SerializedName;
import ru.ecole39.ext.api.utils.Gsonable;

public final class AuthResponse implements Gsonable {
    @SerializedName("access_token") public String accessToken;
    @SerializedName("refresh_token") public String refreshToken;
    public User user;
}
