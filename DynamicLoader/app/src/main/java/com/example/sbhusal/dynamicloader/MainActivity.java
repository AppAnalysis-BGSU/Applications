package com.example.sbhusal.dynamicloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private static TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytext=findViewById(R.id.myText);
       loadClass();
    }

    public static void loadClass()
    {
        ClassLoader classLoader=MainActivity.class.getClassLoader();

        try {
            Class myClass=classLoader.loadClass("sampledata.HiddenCode");
            Constructor constructor=myClass.getConstructor();
            Object myClassObj=constructor.newInstance();
            Method method=myClass.getMethod("getString");
            String textString= (String) method.invoke(myClassObj);
            mytext.setText(textString);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
