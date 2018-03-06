package com.example.sbhusal.dynamicloader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayView=findViewById(R.id.displayView);
        setContentView(R.layout.activity_main);
        displayView.setText(getString());
    }
    public String getString() {
        //ClassLoader classLoader=MainActivity.class.getClassLoader();
        //DexClassLoader dex=new DexClassLoader("data/apk",null,null,ClassLoader.getSystemClassLoader());
        return "Hello";

    }
}
