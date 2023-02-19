package ru.ecole39.ext.api.storage;

import android.content.Context;

public class StorageManager {
    private final KeyValueStorage keyValueStorage;

    public StorageManager(Context context) {
        this.keyValueStorage = new KeyValueStorageImpl(context);
    }

    public StorageManager putAccessToken(String accessToken) {
        this.keyValueStorage.put("access_token", accessToken);
        return this;
    }

    public StorageManager putRefreshToken(String refreshToken) {
        this.keyValueStorage.put("refresh_token", refreshToken);
        return this;
    }

    public String getAccessToken() {
        return this.keyValueStorage.getValue("access_token");
    }

    public String getRefreshToken() {
        return this.keyValueStorage.getValue("refresh_token");
    }

    public KeyValueStorage getStorage() {
        return keyValueStorage;
    }
}
