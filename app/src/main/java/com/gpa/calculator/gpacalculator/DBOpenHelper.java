package com.gpa.calculator.gpacalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "history.db";
    private  static final int DATABASE_VERSION = 3;

    //Constants for identifying table and columns
    static final String TABLE_HISTORY = "history";

    static final String CHANNEL_ID = "_id";
    static final String SEMESTER_GPA = "semester_gpa";
    static final String CREATED_AT = "created_at";


    static final String[] ALL_COLUMNS =
            {CHANNEL_ID,SEMESTER_GPA,CREATED_AT};


    //SQL to create table
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_HISTORY + " (" + CHANNEL_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + SEMESTER_GPA + " TEXT, "+ CREATED_AT + " TEXT default CURRENT_TIMESTAMP"+");";

    DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
        onCreate(db);
    }



}