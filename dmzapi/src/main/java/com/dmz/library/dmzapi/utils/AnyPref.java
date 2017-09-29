package com.dmz.library.dmzapi.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dengmingzhi on 16/5/10.
 */
public class AnyPref {
    private static Context ctx;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public static void _init(Context context) {
        ctx = context.getApplicationContext();
    }

    public static AnyPref instance(String title) {
        return new AnyPref(title);
    }

    private AnyPref(String title) {
        sp = ctx.getSharedPreferences(title, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public AnyPref putString(String key, String value) {
        editor.putString(key, value);
        return this;
    }

    public AnyPref putInt(String key, int value) {
        editor.putInt(key, value);
        return this;
    }

    public AnyPref putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        return this;
    }

    public AnyPref putFloat(String key, float value) {
        editor.putFloat(key, value);
        return this;
    }

    public AnyPref putLong(String key, long value) {
        editor.putLong(key, value);
        return this;
    }

    public AnyPref commit() {
        editor.commit();
        return this;
    }

    public void clear() {
        editor.clear().commit();
    }


    public long getLong(String key, long... defaultValue) {
        return defaultValue.length > 0 ? sp.getLong(key, defaultValue[0]) : sp.getLong(key, -1);
    }

    public String getString(String key, String... defaultValue) {
        return defaultValue.length > 0 ? sp.getString(key, defaultValue[0]) : sp.getString(key, "");
    }

    public float getFloat(String key, float... defaultValue) {
        return defaultValue.length > 0 ? sp.getFloat(key, defaultValue[0]) : sp.getFloat(key, -1);
    }

    public int getInt(String key, int... defaultValue) {
        return defaultValue.length > 0 ? sp.getInt(key, defaultValue[0]) : sp.getInt(key, -1);
    }

    public boolean getBoolean(String key, boolean... defaultValue) {
        return defaultValue.length > 0 ? sp.getBoolean(key, defaultValue[0]) : sp.getBoolean(key, false);
    }
}
