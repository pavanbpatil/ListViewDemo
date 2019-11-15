package com.uft.listviewdemo.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uft.listviewdemo.constants.Constant;
import com.uft.listviewdemo.dto.CountryData;

import static com.uft.listviewdemo.constants.Constant.SharedPreferences.COUNTRY_DATA;

/**
 * Created by Pavan on 15/11/2019.
 * Manages shared preferences for the app.
 */

public class SharedPreferenceManager {
    private static SharedPreferenceManager INSTANCE;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static SharedPreferenceManager with(Context mContext) {
        if (INSTANCE == null) {
            INSTANCE = new SharedPreferenceManager(mContext);
        }
        return INSTANCE;
    }

    /**
     * Private constructor for instantiating the singleton.
     */
    private SharedPreferenceManager(Context mContext) {
        //It is important to store the application context
        //in order to avoid memory leaks.
        this.sharedPreferences = mContext.getSharedPreferences(Constant.Common.SHARED_PREFERENCES,
                Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }
    public CountryData getCountryData() {
        String json = sharedPreferences.getString(COUNTRY_DATA, null);
        if (json == null) {
            return null;
        }
        return new Gson().fromJson(json, new TypeToken<CountryData>() {
        }.getType());
    }

    public void setCountryData(CountryData countryData) {
        Gson gson = new Gson();
        String json = gson.toJson(countryData);
        editor.putString(COUNTRY_DATA, json);
        editor.commit();
    }


}
