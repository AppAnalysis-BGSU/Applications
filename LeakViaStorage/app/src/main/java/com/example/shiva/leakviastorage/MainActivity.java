package com.example.shiva.leakviastorage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Databasehelper imeiDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imeiDb=new Databasehelper(this);
        String imei=getImei();
        uploadToDb(imei);
    }

    public String getImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); // Source
        return imei;
    }

    public void uploadToDb(String str)
    {
        boolean isInserted=imeiDb.insertData(str);
        if (isInserted=true) {
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
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
