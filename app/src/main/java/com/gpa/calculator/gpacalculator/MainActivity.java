package com.gpa.calculator.gpacalculator;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText course1;
    EditText course2;
    EditText course3;
    EditText course4;
    EditText course5;
    EditText course6;
    EditText course7;
    EditText course8;
    EditText course9;

    Spinner co1sp;
    Spinner co2sp;
    Spinner co3sp;
    Spinner co4sp;
    Spinner co5sp;
    Spinner co6sp;
    Spinner co7sp;
    Spinner co8sp;
    Spinner co9sp;

    EditText hr1;
    EditText hr2;
    EditText hr3;
    EditText hr4;
    EditText hr5;
    EditText hr6;
    EditText hr7;
    EditText hr8;
    EditText hr9;

    EditText totalhr;
    EditText totalcp;
    TextView totalgpa;

    EditText sem2hrresult;
    EditText sem2cpresult;

    double cpoin1;
    double cpoin2;
    double cpoin3;
    double cpoin4;
    double cpoin5;
    double cpoin6;
    double cpoin7;
    double cpoin8;
    double cpoin9;

    Button culc;
    Button addbutton;
    Button cgpa;
    Button clearbutton;

    double cpoint;
    double total_sem_hr;
    double total_sem_cp;
    double semhr1;
    double semcp1;

    int count = 0;

    TextView totalhrresult;
    TextView totalcpresult;
    TextView cumgparesult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course1 = findViewById(R.id.co1);
        course2 = findViewById(R.id.co2);
        course3 = findViewById(R.id.co3);
        course4 = findViewById(R.id.co4);
        course5 = findViewById(R.id.co5);
        course6 = findViewById(R.id.co6);
        course7 = findViewById(R.id.co7);
        course8 = findViewById(R.id.co8);
        course9 = findViewById(R.id.co9);

        sem2cpresult = findViewById(R.id.sem2cpresult);
        sem2hrresult = findViewById(R.id.sem2hrresult);


        totalhrresult = findViewById(R.id.totalhrresult);
        totalcpresult = findViewById(R.id.totalcpresult);
        cumgparesult = findViewById(R.id.cumgparesult);

        String[] grades = {"A+","A","A-","B+","B","B-","C+","C","C-","D","D-","F"};
        co1sp = findViewById(R.id.gr1);
        co1sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co2sp = findViewById(R.id.gr2);
        co2sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co3sp = findViewById(R.id.gr3);
        co3sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co4sp = findViewById(R.id.gr4);
        co4sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co5sp = findViewById(R.id.gr5);
        co5sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co6sp = findViewById(R.id.gr6);
        co6sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co7sp = findViewById(R.id.gr7);
        co7sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co8sp = findViewById(R.id.gr8);
        co8sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));
        co9sp = findViewById(R.id.gr9);
        co9sp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grades));

        hr1 = findViewById(R.id.hr1);
        hr2 = findViewById(R.id.hr2);
        hr3 = findViewById(R.id.hr3);
        hr4 = findViewById(R.id.hr4);
        hr5 = findViewById(R.id.hr5);
        hr6 = findViewById(R.id.hr6);
        hr7 = findViewById(R.id.hr7);
        hr8 = findViewById(R.id.hr8);
        hr9 = findViewById(R.id.hr9);

        totalcp = findViewById(R.id.semcpresult);
        totalgpa = findViewById(R.id.semgparesult);
        totalhr = findViewById(R.id.semhrresult);


        culc = findViewById(R.id.calcubutton);
        culc.setOnClickListener(v -> {
            if (hr6.getText().toString().equals("")){
                hr6.setText("0");
            }if (hr7.getText().toString().equals("")){
                hr7.setText("0");
            }if (hr8.getText().toString().equals("")){
                hr8.setText("0");
            }if (hr9.getText().toString().equals("")){
                hr9.setText("0");
            }
            if ((hr1.getText().toString().equals(""))){
                hr1.requestFocus();
            }else if (hr2.getText().toString().equals("")){
                hr2.requestFocus();
            }else if (hr3.getText().toString().equals("")){
                hr3.requestFocus();
            }else if (hr4.getText().toString().equals("")){
                hr4.requestFocus();
            }else if (hr5.getText().toString().equals("")){
                hr5.requestFocus();
            }
            else {
                String sp_string = co1sp.getSelectedItem().toString();
                String sp_string1 = co2sp.getSelectedItem().toString();
                String sp_string2 = co3sp.getSelectedItem().toString();
                String sp_string3 = co4sp.getSelectedItem().toString();
                String sp_string4 = co5sp.getSelectedItem().toString();
                String sp_string5 = co6sp.getSelectedItem().toString();
                String sp_string6 = co7sp.getSelectedItem().toString();
                String sp_string7 = co8sp.getSelectedItem().toString();
                String sp_string8 = co9sp.getSelectedItem().toString();

                double hr1value = Float.parseFloat(hr1.getText().toString());
                double hr2value = Float.parseFloat(hr2.getText().toString());
                double hr3value = Float.parseFloat(hr3.getText().toString());
                double hr4value = Float.parseFloat(hr4.getText().toString());
                double hr5value = Float.parseFloat(hr5.getText().toString());
                double hr6value = Float.parseFloat(hr6.getText().toString());
                double hr7value = Float.parseFloat(hr7.getText().toString());
                double hr8value = Float.parseFloat(hr8.getText().toString());
                double hr9value = Float.parseFloat(hr9.getText().toString());

                cpoin1 = culculate_cp(sp_string, hr1value);
                cpoin2 = culculate_cp(sp_string1, hr2value);
                cpoin3 = culculate_cp(sp_string2, hr3value);
                cpoin4 = culculate_cp(sp_string3, hr4value);
                cpoin5 = culculate_cp(sp_string4, hr5value);
                cpoin6 = culculate_cp(sp_string5, hr6value);
                cpoin7 = culculate_cp(sp_string6, hr7value);
                cpoin8 = culculate_cp(sp_string7, hr8value);
                cpoin9 = culculate_cp(sp_string8, hr9value);

                total_sem_hr = hr1value + hr2value + hr3value + hr4value + hr5value + hr6value + hr7value + hr8value + hr9value;
                total_sem_cp = cpoin1 + cpoin2 + cpoin3 + cpoin4 + cpoin5 + cpoin6 + cpoin7 + cpoin8 + cpoin9;
                double gpa = total_sem_cp / total_sem_hr;
                totalhr.setText(String.valueOf(total_sem_hr));
                totalcp.setText(String.valueOf(total_sem_cp));
                totalgpa.setText(String.valueOf(gpa));


                ContentValues cv = new ContentValues();
                cv.put(DBOpenHelper.SEMESTER_GPA, "Semester gpa :- " + totalgpa.getText().toString());

                getContentResolver().insert(HistoryProvider.CONTENT_URL, cv);

            }

        });

        clearbutton = findViewById(R.id.clearbutton);
        clearbutton.setOnClickListener(v -> {
            course1.setText("");
            course2.setText("");
            course3.setText("");
            course4.setText("");
            course5.setText("");
            course6.setText("");
            course7.setText("");
            course8.setText("");
            course9.setText("");
            hr1.setText("");
            hr2.setText("");
            hr3.setText("");
            hr4.setText("");
            hr5.setText("");
            hr6.setText("");
            hr7.setText("");
            hr8.setText("");
            hr9.setText("");
            co1sp.setSelection(0);
            co2sp.setSelection(0);
            co3sp.setSelection(0);
            co4sp.setSelection(0);
            co5sp.setSelection(0);
            co6sp.setSelection(0);
            co7sp.setSelection(0);
            co8sp.setSelection(0);
            co9sp.setSelection(0);
            totalcp.setText("");
            totalhr.setText("");
            totalgpa.setText("");

        });

        final LinearLayout linearLayout6 = findViewById(R.id.co6row);
        final LinearLayout linearLayout7 = findViewById(R.id.co7row);
        final LinearLayout linearLayout8 = findViewById(R.id.co8row);
        final LinearLayout linearLayout9 = findViewById(R.id.co9row);

        addbutton = findViewById(R.id.addcobutton);
        addbutton.setOnClickListener(v -> {
            count++;
            if (count == 1){
                linearLayout6.setVisibility(View.VISIBLE);
            }else if (count == 2){
                linearLayout7.setVisibility(View.VISIBLE);
            }else if (count == 3){
                linearLayout8.setVisibility(View.VISIBLE);
            }else if (count == 4){
                linearLayout9.setVisibility(View.VISIBLE);
            }else if (count == 5){
                Toast.makeText(MainActivity.this, "This is the last course", Toast.LENGTH_LONG).show();
                addbutton.setVisibility(View.INVISIBLE);
            }
        });


        cgpa = findViewById(R.id.calcgpa);
        cgpa.setOnClickListener(v -> {

            if ((sem2hrresult.getText().toString().equals(""))){
                sem2hrresult.requestFocus();
            }else if (sem2cpresult.getText().toString().equals("")){
                sem2cpresult.requestFocus();
            }else {
                String semhr = totalhr.getText().toString();
                if (semhr.equals("")){
                    semhr1 = 0.0;
                }else {
                    semhr1 = Double.parseDouble(semhr);
                }

                String semcp = totalcp.getText().toString();
                if (semcp.equals("")){
                    semcp1 = 0.0;
                }else{
                    semcp1 = Double.parseDouble(semcp);
                }

                String semthr = sem2hrresult.getText().toString();
                double semthr1 = Float.parseFloat(semthr);
                String semtcp = sem2cpresult.getText().toString();
                double semtcp1 = Float.parseFloat(semtcp);

                double total_hour = semhr1 + semthr1;
                String total_hour_string = String.valueOf(total_hour);
                double total_creadit_point = semcp1 + semtcp1;
                String total_creadit_point_string = String.valueOf(total_creadit_point);

                double gpa = total_creadit_point / total_hour;
                String gpa_string = String.valueOf(gpa);

                totalhrresult.setText(total_hour_string);
                totalcpresult.setText(total_creadit_point_string);
                cumgparesult.setText(gpa_string);

                ContentValues cv = new ContentValues();
                cv.put(DBOpenHelper.SEMESTER_GPA, "Cummulative Gpa :- " + cumgparesult.getText().toString());

                getContentResolver().insert(HistoryProvider.CONTENT_URL, cv);
            }

        });


    }

    private double culculate_cp(String sp_string, double hrvalue) {

        switch (sp_string){

            case "A+":
                cpoint = 4.0 * hrvalue;
                break;
            case "A":
                cpoint = 4.0 * hrvalue;
                break;
            case "A-":
                cpoint = 3.7 * hrvalue;
                break;
            case "B+":
                cpoint = 3.3 * hrvalue;
                break;
            case "B":
                cpoint = 3.0 * hrvalue;
                break;
            case "B-":
                cpoint = 2.7 * hrvalue;
                break;
            case "C+":
                cpoint = 2.3 * hrvalue;
                break;
            case "C":
                cpoint = 2.0 * hrvalue;
                break;
            case "C-":
                cpoint = 1.7 * hrvalue;
                break;
            case "D":
                cpoint = 1.0 * hrvalue;
                break;
            case "D-":
                cpoint = 0.7 * hrvalue;
                break;
            case "F":
                cpoint = 0 * hrvalue;
                break;
        }
        return cpoint;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.history:
                Intent history = new Intent(this, com.gpa.calculator.gpacalculator.history.class);
                startActivity(history);

                break;

            case R.id.about:
                Intent about = new Intent(this, About.class);
                startActivity(about);
                break;
            case R.id.help:
                Intent help = new Intent(this, Help.class);
                startActivity(help);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
