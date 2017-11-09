package com.example.shiva.registerme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button faculty;
    Button students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faculty=(Button)findViewById(R.id.faculty);
        students=(Button)findViewById(R.id.students);
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faculty=new Intent(MainActivity.this,FacultyActivity.class);
                startActivity(faculty);

            }
        });
        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stud=new Intent(MainActivity.this,StudentActivity.class);
                startActivity(stud);
            }
        });
    }
}
