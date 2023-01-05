package com.example.sjcet.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class MyDatabase extends SQLiteOpenHelper{
    public MyDatabase(Context context){
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME text,MARKS INTEGER)");

    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS USERS");

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from users",null);
        return res;
    }



    public  int deletedata( String UserVal)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int i=db.delete("USERS","NAME=?",new String[]{UserVal});
        return  i;

    }


}
