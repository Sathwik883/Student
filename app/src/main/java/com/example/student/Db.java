package com.example.student;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db extends SQLiteOpenHelper {
    static SQLiteDatabase sq;
    static String tblname="blooddata";
    static String colname="Name";
    static String colmob="Mobile";
    static String colloc="Location";
    static String coldob="DOB";
    static String colbldgr="bloodgr";
    static String res="";
    //create table blooddata(Name text,Mobile text,Location text,Date of Birth text,bloodgr text);
    String qry="create table "+tblname+"("+colname+" text,"+colmob+" text,"+colloc+" text,"+coldob+" text,"+colbldgr+" text"+")";
    public Db(Context context) {
        super(context, "blooddb.db",null,1);
        sq=getWritableDatabase();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void Signup(String stnam, String stmob, String stloc, String stdob, String stbldgr) {
        ContentValues cv=new ContentValues();
        cv.put(colname,stnam);
        cv.put(colmob,stmob);
        cv.put(colloc,stloc);
        cv.put(coldob,stdob);
        cv.put(colbldgr,stbldgr);
        sq.insert("blooddata",null,cv);
    }
    @SuppressLint("Recycle")
    public static String getda(String stbldgr) {
        Cursor c;
        c = sq.query(tblname, null, colbldgr + "=?", new String[]{stbldgr}, null, null, null);
        c.moveToFirst();
        if (c.getCount() < 1) {
            return "no data";
        }

        do {
            res+="\n"+ c.getString(c.getColumnIndex(colname)) + "\n" +
                    c.getString(c.getColumnIndex(colmob)) + "\n" +
                    c.getString(c.getColumnIndex(colloc)) + "\n" +
                    c.getString(c.getColumnIndex(coldob));
        }while(c.moveToNext());
        return res;
    }
}