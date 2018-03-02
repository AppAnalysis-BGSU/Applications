package com.example.sbhusal.dynamicloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    public static TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayView=findViewById(R.id.displayView);
        try {
            loadClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadClass() throws ClassNotFoundException {
        ClassLoader classLoader=MainActivity.class.getClassLoader();
        String myStr;
            Class aClass=classLoader.loadClass("C:\\Users\\sbhusal\\Documents\\GIT\\Applications\\DynamicLoader\\app\\src\\main\\res\\files");
            myStr=aClass.getName();
        displayView.setText("Hello BGSU !!");
        setContentView(R.layout.activity_main);
    }
}
