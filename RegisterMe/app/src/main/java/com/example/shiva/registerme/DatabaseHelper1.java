package com.example.shiva.registerme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shiva on 8/17/2017.
 */

public class DatabaseHelper1 extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="student_table";
    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="EMAIL";
    public static final String COL4="HOMETOWN";
    public static final String COL5="INTEREST";
    public static final String COL6="AGE";

    public DatabaseHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, HOMETOWN TEXT,INTEREST TEXT, AGE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String email, String hometown, String interest,String age){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,hometown);
        contentValues.put(COL5,interest);
        contentValues.put(COL6,age);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM student_table";
        Cursor res=db.rawQuery(query,null);
        return res;

    }
    public Cursor getStateData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT HOMETOWN, COUNT(*) FROM student_table GROUP BY HOMETOWN";
        Cursor state=db.rawQuery(query,null);
        return state;

    }
    public Cursor getAgeData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT AGE, COUNT(*) FROM student_table GROUP BY HOMETOWN";
        Cursor age=db.rawQuery(query,null);
        return age;

    }
}
