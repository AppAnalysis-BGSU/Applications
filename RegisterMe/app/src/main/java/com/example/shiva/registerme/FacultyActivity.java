package com.example.shiva.registerme;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FacultyActivity extends AppCompatActivity {
    DatabaseHelper1 myDb;
    Button btnViewAll;
    Button btnViewByState;
    Button btnSendEmail;
    Button btnViewByAge;
    Button btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        myDb=new DatabaseHelper1(this);
        btnViewAll=(Button)findViewById(R.id.viewAll);
        btnViewByState=(Button)findViewById(R.id.viewByState);
        btnSendEmail=(Button)findViewById(R.id.sendemail);
        btnViewByAge=(Button)findViewById(R.id.viewByAge);
        btnSendSms=(Button)findViewById(R.id.sendsms);
        viewAll();
        viewStateData();
        viewAgeData();
        sendEmail();
        sendSms();
    }
    public void viewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Cursor res=myDb.getAllData();
                                              if(res.getCount()==0){
                                                  //show message
                                                  showMessage("Error","Nothing Found");

                                                  return;
                                              }
                                              StringBuffer buffer=new StringBuffer();
                                              while (res.moveToNext()){
                                                  buffer.append("ID:"+ res.getString(0)+"\n");
                                                  buffer.append("Name:"+ res.getString(1)+"\n");
                                                  buffer.append("Email:"+ res.getString(2)+"\n");
                                                  buffer.append("State:"+ res.getString(3)+"\n");
                                                  buffer.append("Interest:"+ res.getString(4)+"\n");
                                                  buffer.append("Age:"+ res.getString(5)+"\n\n");
                                              }
                                              //show all data
                                              showMessage("Student Details",buffer.toString());
                                          }
                                      }
        );
    }
    public void viewStateData(){
        btnViewByState.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.getStateData();
                        if(res.getCount()==0){
                            //show message
                            showMessage("Error","Nothing Found");

                            return;
                        }
                        StringBuffer bufferState=new StringBuffer();
                        while (res.moveToNext()){
                            bufferState.append("State:"+ res.getString(0)+"\n");
                            bufferState.append("Count:"+ res.getString(1)+"\n\n");
                        }
                        //show all data
                        showMessage("Distribution by state",bufferState.toString());
                    }
                }
        );
    }
    public void viewAgeData(){
        btnViewByAge.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=myDb.getAgeData();
                        if(res.getCount()==0){
                            //show message
                            showMessage("Error","Nothing Found");

                            return;
                        }
                        StringBuffer bufferAge=new StringBuffer();
                        while (res.moveToNext()){
                            bufferAge.append("Age:"+ res.getString(0)+"\n");
                            bufferAge.append("Count:"+ res.getString(1)+"\n\n");
                        }
                        //show all data
                        showMessage("Distribution by age",bufferAge.toString());
                    }
                }
        );
    }
    public void sendEmail(){
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                //String[] to={"sbhusal@bgsu.edu"}; // email address hardcoded
                //intent.putExtra(Intent.EXTRA_EMAIL,to);
                Cursor res=myDb.getAllData();
                if(res.getCount()==0){
                    //show message
                    showMessage("Error","Nothing Found");

                    return;
                }
                StringBuffer bufferEmail=new StringBuffer();
                while (res.moveToNext()) {
                    bufferEmail.append("ID:" + res.getString(0) + "\n");
                    bufferEmail.append("Name:" + res.getString(1) + "\n");
                    bufferEmail.append("Email:" + res.getString(2) + "\n");
                    bufferEmail.append("State:" + res.getString(3) + "\n");
                    bufferEmail.append("Interest:" + res.getString(4) + "\n");
                    bufferEmail.append("Age:" + res.getString(5) + "\n\n");
                }
                intent.putExtra(Intent.EXTRA_SUBJECT,"Student Details from RegisterMe "+"("+res.getCount()+")");
                intent.putExtra(Intent.EXTRA_TEXT,bufferEmail.toString());
                intent.setType("message/rfc822");
                Intent chooser=Intent.createChooser(intent,"Send Email");
                startActivity(chooser);
            }
        });

        }
        public void sendSms()
        {
            btnSendSms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(Intent.ACTION_SEND);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("sms_body", "Hello World");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }



                }
            });


        }



    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
