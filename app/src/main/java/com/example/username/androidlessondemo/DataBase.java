package com.example.username.androidlessondemo;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private String name="demo";
    private static int VERSION=1;//数据库版本
    private SQLiteDatabase sqLiteDatabase;//数据库实例


    private static final String DEFAULT="CREATE TABLE IF NOT EXISTS words(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "word TEXT," +
            "trans TEXT" +
            ")";



    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        sqLiteDatabase=getReadableDatabase();

        sqLiteDatabase.execSQL(DEFAULT);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
