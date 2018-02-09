package com.privateActivity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.telephony.TelephonyManager;


/**
 * Created by dewan on 1/27/18.
 */

public class ServClass extends Service {


   IBinder mBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        public ServClass getServerInstance() {
            return ServClass.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String imei = obtainImei();
        HiddenActivity obj = new HiddenActivity();
        obj.LeakImei(imei);

        return super.onStartCommand(intent, flags, startId);
    }

    public String obtainImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); //source
        return imei;
    }



}