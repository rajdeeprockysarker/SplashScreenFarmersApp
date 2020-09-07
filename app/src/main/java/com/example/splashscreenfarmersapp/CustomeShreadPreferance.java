package com.example.splashscreenfarmersapp;

import android.content.Context;
import android.content.SharedPreferences;

public class CustomeShreadPreferance {
    public static final String PREFS_LANGUAGE="com.reisystems.language";
    public static final String KEY= "LanguageKey";

    public static void saveDefaultLanguage(Context cntx, String ln){
        SharedPreferences sp = cntx.getSharedPreferences(PREFS_LANGUAGE , Context.MODE_PRIVATE);
        sp.edit().putString(KEY,ln).commit();
    }

    public static String  getDefaultLanguage(Context cntx){
        SharedPreferences sp = cntx.getSharedPreferences(PREFS_LANGUAGE ,Context.MODE_PRIVATE);
        String sc  = sp.getString(KEY,"");
        return sc;
    }

}
