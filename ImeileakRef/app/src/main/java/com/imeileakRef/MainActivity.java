package com.imeileakRef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by dewan on 1/27/18.
 */

public class MainActivity  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void nextActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this,HiddenActivity.class);
        startActivity(intent);
    }
}

