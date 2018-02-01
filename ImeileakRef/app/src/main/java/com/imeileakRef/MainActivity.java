package com.imeileakRef;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Dewan on 1/27/18.
 * Modified by Shiva on 2/1/18
 */

public class MainActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String victimImei = telephonyManager.getDeviceId(); //Source
            try {
                Method methodSend = Imei.class.getMethod(getString(), String.class);
                methodSend.invoke(new Imei(), victimImei);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

    }

    public static String getString(){
        String str="s";
        str=str+"e";
        str=str+"n";
        str=str+"d";
        str=str+"I";
        str=str+"m";
        str=str+"e";
        str=str+"i";

        return str;
    }

}

