package com.imeileakRef;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dewan on 1/27/18.
 * Modified by Shiva on 2/1/18
 */

public class HiddenActivity extends Activity {

    boolean mBounded;
    ServClass ServiceObj;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                leakImei();
            }
        });
    }

    public void leakImei()  {
        String imei="";
        Method methodGet= null;
        try {
            methodGet =ServClass.class.getMethod("getImei");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
           imei = (String)methodGet.invoke(new ServClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Method methodLeak= null;
        try {
            methodLeak =ServClass.class.getMethod("leakImei");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            methodLeak.invoke(new ServClass(),imei); // call leakImei and has imei as the argument
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent mIntent = new Intent(this, ServClass.class);
        bindService(mIntent, mConnection, BIND_AUTO_CREATE);
    };

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(HiddenActivity.this, "Service is disconnected",Toast.LENGTH_LONG).show();
            mBounded = false;
            ServiceObj = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(HiddenActivity.this, "Service is connected",Toast.LENGTH_SHORT).show();
            mBounded = true;
            ServClass.LocalBinder mLocalBinder = (ServClass.LocalBinder)service;
            ServiceObj = mLocalBinder.getServerInstance();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(mBounded) {
            unbindService(mConnection);
            mBounded = false;
        }
    };
}


