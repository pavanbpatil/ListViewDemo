package com.uft.listviewdemo;

import android.app.Application;
import android.content.Context;

import com.uft.listviewdemo.dto.CountryData;
import com.uft.listviewdemo.preference.SharedPreferenceManager;

/**
 * * Created by Pavan on 15/11/2019.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static CountryData getCountryData(Context context) {
        return SharedPreferenceManager.with(context).getCountryData();
    }

    public static void setCountryData(Context context, CountryData countryData) {
        SharedPreferenceManager.with(context).setCountryData(countryData);
    }

}
