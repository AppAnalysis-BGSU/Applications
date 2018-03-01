package com.example.shiva.sharedpreference_noLeakage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;


public class MainActivity extends AppCompatActivity {
    public static final String PREF="myPrefFile";
    public static final String IMEI="imei";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeImei(getImei());
    }
    public String getImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); // Source
        return imei;
    }

    public void storeImei(String imei)
    {
        sharedPref=getSharedPreferences(PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString(IMEI,imei);
        editor.commit();
    }
}