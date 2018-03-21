package com.example.shiva.lockscreen;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class OverlayService extends Service {
    LinearLayout oView;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        oView=new LinearLayout(this);
        oView.setBackgroundColor(0xFFFFFFFF);
        // Here, value of the third parameter can be TYPE_SYSTEM_ERROR or LAYOUT_FULLSCREEN
        // Inetger value 2010 or 1014 
        WindowManager.LayoutParams params=new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                PixelFormat.TRANSLUCENT
        );
        WindowManager wm=(WindowManager)getSystemService(WINDOW_SERVICE);
        wm.addView(oView,params);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

}
