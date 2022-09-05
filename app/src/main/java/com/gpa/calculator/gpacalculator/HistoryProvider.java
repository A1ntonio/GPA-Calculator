package com.gpa.calculator.gpacalculator;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

public class HistoryProvider extends ContentProvider {

    //the problem may occure in here
    //if this authorty is not correct fix it also in androidmanifest.xml
    private static final String AUTHORITY = "com.gpa.calculator.gpacalculator.historyprovider";
    private static final String BASE_PATH = "history";
    public static final Uri CONTENT_URL =
            Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    //Constant to identify the requested operation
    private static final int HISTORY = 1;
    private static final int HISTORY_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, HISTORY);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", HISTORY_ID);
    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {

        DBOpenHelper helper = new DBOpenHelper(getContext());

        database = helper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {


        return database.query(DBOpenHelper.TABLE_HISTORY, DBOpenHelper.ALL_COLUMNS, selection, null, null, null, DBOpenHelper.CREATED_AT + " DESC");
    }

    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        long id = database.insert(DBOpenHelper.TABLE_HISTORY, null, values);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        return database.delete(DBOpenHelper.TABLE_HISTORY, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return database.update(DBOpenHelper.TABLE_HISTORY, values, selection, selectionArgs);
    }
}
