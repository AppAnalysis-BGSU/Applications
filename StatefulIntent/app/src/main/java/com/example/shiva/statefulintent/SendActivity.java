package com.example.shiva.statefulintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        String imei="abc";
        Intent returnIntent=new Intent();
        returnIntent.putExtra("result",imei);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
