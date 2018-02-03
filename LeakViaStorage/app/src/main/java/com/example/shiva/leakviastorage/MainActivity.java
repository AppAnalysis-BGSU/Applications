package com.example.shiva.leakviastorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String imei=getImei();
        uploadImeiToDb(imei);
    }

    public String getImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); // Source
        return imei;
    }

    public void uploadImeiToDb(String imei)
    {

    }

    public String retriveImei()
    {
        String str="";
        return str;
    }

    public void leakImei()
    {

    }
    
}
