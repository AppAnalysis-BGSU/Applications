package com.example.shiva.registerme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {
    DatabaseHelper1 myDb;
    EditText editName, editEmail, editHometown, editInterest,editAge;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        myDb=new DatabaseHelper1(this);

        editName=(EditText)findViewById(R.id.name);
        editEmail=(EditText)findViewById(R.id.email);
        editHometown=(EditText)findViewById(R.id.hometown);
        editInterest=(EditText)findViewById(R.id.interest);
        editAge=(EditText)findViewById(R.id.age);
        btnSubmit=(Button)findViewById(R.id.submit);
        AddData();
    }
    public void AddData()
    {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted=myDb.insertData(editName.getText().toString(),editEmail.getText().toString(),
                        editHometown.getText().toString(),editInterest.getText().toString(),editAge.getText().toString());
                if (isInserted=true) {
                    Toast.makeText(StudentActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(StudentActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();




            }
        });
    }

}
