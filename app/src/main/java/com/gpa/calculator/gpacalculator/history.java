package com.gpa.calculator.gpacalculator;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class history extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Cursor cursor = getContentResolver().query(HistoryProvider.CONTENT_URL, DBOpenHelper.ALL_COLUMNS, null, null, null, null);
        String[] from = {DBOpenHelper.SEMESTER_GPA};
        int[] to = {android.R.id.text1};


        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, from, to, 0);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(cursorAdapter);
        listView.setOnItemLongClickListener((parent, view, position, id) -> {

            Uri uri = Uri.parse(HistoryProvider.CONTENT_URL + "/" + id);

            String historyFiltor = DBOpenHelper.CHANNEL_ID + "=" + uri.getLastPathSegment();
            DialogInterface.OnClickListener dialogClickListener = (dialog, button) -> {

                if (button == DialogInterface.BUTTON_POSITIVE) {
                    getContentResolver().delete(HistoryProvider.CONTENT_URL,historyFiltor,null);
                    restartLoader();
                    Toast.makeText(history.this, "Deleted", Toast.LENGTH_LONG).show();
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Delete");
            builder.setMessage("Are you sure?").setPositiveButton(getString(android.R.string.yes),dialogClickListener).setNegativeButton(getString(android.R.string.cancel),dialogClickListener).show();
        return true;
        });
    }

    private void restartLoader() {
        getLoaderManager().restartLoader(0,null,this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this,HistoryProvider.CONTENT_URL,null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.delete_all_item:
                if (cursorAdapter.getCount() == 0) {
                    Toast.makeText(history.this, "No history recorded", Toast.LENGTH_LONG).show();
                }else {
                    deleteAll();
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAll() {

        DialogInterface.OnClickListener dialogClickListener = (dialog, button) -> {

            if (button == DialogInterface.BUTTON_POSITIVE) {
                getContentResolver().delete(HistoryProvider.CONTENT_URL,null,null);
                restartLoader();
                Toast.makeText(history.this, "Deleted successfully!", Toast.LENGTH_SHORT).show();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete all history");
        builder.setMessage("Are you sure?").setPositiveButton(getString(android.R.string.yes),dialogClickListener).setNegativeButton(getString(android.R.string.cancel),dialogClickListener).show();

    }

}
