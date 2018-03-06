package com.example.shiva.dynamicloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),getString(),Toast.LENGTH_LONG).show();
    }

    public String getString()
    {
        return "Hello World from method";
    }
}
