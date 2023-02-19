package ru.ecole39.ext.api.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class KeyValueStorageImpl implements KeyValueStorage {
    private final Context context;

    public KeyValueStorageImpl(Context context) {
        this.context = context;
    }

    protected SharedPreferences getPrefs() {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    @Override
    public KeyValueStorage put(String key, String value) {
        getPrefs().edit().putString(key, value).apply();
        return this;
    }

    @Override
    public KeyValueStorage put(String key, int value) {
        return this;
    }

    @Override
    public KeyValueStorage put(String key, long value) {
        return this;
    }

    @Override
    public String getValue(String key) {
        return getPrefs().getString(key, null);
    }

    @Override
    public Integer getInt(String key) {
        return getPrefs().getInt(key, 0);
    }

    @Override
    public Long getLong(String key) {
        return getPrefs().getLong(key, 0);
    }

    @Override
    public KeyValueStorage clear() {
        getPrefs().edit().clear().apply();
        return this;
    }
}
