package ru.ecole39.ext.api.models.requests;

import com.google.gson.annotations.SerializedName;
import ru.ecole39.ext.api.utils.Gsonable;

public class AuthRequestBase implements Gsonable {
    @SerializedName("grant_type") public String grantType;
    @SerializedName("system_id") public String systemId;

    public AuthRequestBase(String grantType, String systemId) {
        this.grantType = grantType;
        this.systemId = systemId;
    }
}
