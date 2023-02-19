package ru.ecole39.ext.api.utils;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;

public class Utils {
    public static String getSystemId(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        if (androidId == null)
            androidId = System.getProperty("ro.serialno");
        return androidId;
    }
}
