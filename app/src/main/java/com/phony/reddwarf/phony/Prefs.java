package com.phony.reddwarf.phony;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by RedDwarf on 11/24/2015.
 */
public class Prefs {

    private static final String prefsName = "com.reddwarf.phony.prefs";
    private static final String clickName = "reddwarf.phony.prefs.clicks";


    public static int getClickCounts(Activity activity) {
        SharedPreferences preferences = activity.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        return preferences.getInt(clickName, 0);
    }

    public static void setClickCount(Activity activity, int value)
    {
        SharedPreferences preferences = activity.getSharedPreferences(prefsName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(clickName, value);
        editor.apply(); //or editor.commit();
    }
}
