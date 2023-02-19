package ru.ecole39.ext.api.storage;

public interface KeyValueStorage {
    KeyValueStorage put(String key, String value);
    KeyValueStorage put(String key, int value);
    KeyValueStorage put(String key, long value);

    String getValue(String key);
    Integer getInt(String key);
    Long getLong(String key);

    KeyValueStorage clear();
}
