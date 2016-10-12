package com.abdelalimallam.instarefrance.activity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by Moh Nage7 on 12/10/2016.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String language = Locale.getDefault().getLanguage();
        if (language.equals("ar")) {
            SharedPreferences sharedPreferences = getSharedPreferences("language", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("lang", "ar");
            editor.apply();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("language", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("lang", "en");
            editor.apply();
        }
    }
}
