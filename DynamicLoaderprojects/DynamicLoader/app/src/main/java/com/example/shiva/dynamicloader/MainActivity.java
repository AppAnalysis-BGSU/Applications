package com.example.shiva.dynamicloader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),getString(),Toast.LENGTH_LONG).show();
    }

    public String getString()
    {
        ClassLoader classLoader=MainActivity.class.getClassLoader();
        /*
        Note: Before this, push the APK file to the proper directory in device.
        For eg.adb push app/build/outputs/apk/debug/app-debug.apk data/local/tmp/testapks/load.apk
        */
        DexClassLoader dex=new DexClassLoader("data/local/tmp/testapks/load.apk",null,null,ClassLoader.getSystemClassLoader());
        return "Hello World from method";
    }
}
