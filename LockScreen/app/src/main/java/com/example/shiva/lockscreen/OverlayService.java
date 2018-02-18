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
        WindowManager.LayoutParams params=new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                0 |WindowManager.LayoutParams.FLAG_FULLSCREEN,
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
