package com.example.shiva.lockscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startOverlay();
    }

    public void startOverlay()
    {
        Intent intent=new Intent(this, OverlayService.class);
        if (!stopService(intent))
        {
            startService(intent); 

        }

    }
}
