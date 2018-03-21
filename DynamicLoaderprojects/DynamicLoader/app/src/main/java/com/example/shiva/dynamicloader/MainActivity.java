package com.example.shiva.dynamicloader;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

import dalvik.system.DexClassLoader;

import static java.lang.ClassLoader.getSystemClassLoader;

public class MainActivity extends AppCompatActivity {
    File dexOutputDir =getDir("dex", Context.MODE_PRIVATE);

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
        final DexClassLoader dex=new DexClassLoader("/data/local/tmp/testapks/load.apk",dexOutputDir.getAbsolutePath(),null,getSystemClassLoader());
        return "Hello World from method";
    }
}
