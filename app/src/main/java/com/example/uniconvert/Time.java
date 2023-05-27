package com.example.uniconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Time extends AppCompatActivity {
    TextView ans_display3;
    Spinner spinner7;
    Spinner spinner8;
    Button button5;
    Button calculate3;
    EditText user_input4;
    FloatingActionButton invert4;
    double value1;
    int pos1;
    int pos2;
    String[] siunits = {" ms", " s", " min", " hours", " days", "weeks", "months", "years" };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        ans_display3= findViewById(R.id.ans_display3);

        button5 = findViewById(R.id.button5);
        calculate3 = findViewById(R.id.calculate3);

        user_input4 = findViewById(R.id.user_input4);

        invert4 = findViewById(R.id.invert4);

        spinner7 = findViewById(R.id.spinner7);
        spinner8 = findViewById(R.id.spinner8);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_time1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.units_time2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter2);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos1 = spinner7.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos1, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Snackbar.make(adapterView, "It is ", Snackbar.LENGTH_SHORT).show();
            }
        });
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos2 = spinner8.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos2, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Snackbar.make(adapterView, "It is ", Snackbar.LENGTH_SHORT).show();

            }
        });
        invert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner7.setSelection(pos2);
                spinner8.setSelection(pos1);

            }
        });
        calculate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_value = user_input4.getText().toString();
                try {
                    value1 = Double.parseDouble(input_value);

                } catch (NumberFormatException e) {
                    input_value = "0";
                }
                if (pos1 == pos2) {
                    ans_display3.setText("= " + value1 + siunits[pos2]);

                }
                //ms-->s
                else if (pos1 == 0 && pos2 == 1) {
                    value1 = value1 / 1000;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //ms-->min
                else if (pos1 == 0 && pos2 == 2) {
                    value1 = value1 / 60000;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //ms-->hour
                else if (pos1 == 0 && pos2 == 3) {
                    value1 = value1 / 3.6e+6;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //s-->ms
                else if (pos1 == 1 && pos2 == 0) {
                    value1 = value1 * 1000;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //s-->min
                else if (pos1 == 1 && pos2 == 2) {
                    value1 = value1 / 60;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //s-->hour
                else if (pos1 == 1 && pos2 == 3) {
                    value1 = value1 / 3600;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //s-->day
                else if (pos1 == 1 && pos2 == 4) {
                    value1 = value1 / 86400;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //s-->week
                else if (pos1 == 1 && pos2 == 5) {
                    value1 = value1 / 604800;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //min-->ms
                else if (pos1 == 2 && pos2 == 0) {
                    value1 = value1 * 60000;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->s
                else if (pos1 == 2 && pos2 == 1) {
                    value1 = value1 * 60;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->hour
                else if (pos1 == 2 && pos2 == 3) {
                    value1 = value1 / 60;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->day
                else if (pos1 == 2 && pos2 == 4) {
                    value1 = value1 / 1440;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->week
                else if (pos1 == 2 && pos2 == 5) {
                    value1 = value1 / 10080;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->month
                else if (pos1 == 2 && pos2 == 6) {
                    value1 = value1 / 43800;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //min-->year
                else if (pos1 == 2 && pos2 == 7) {
                    value1 = value1 / 525600;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //hour-->ms
                else if (pos1 == 3 && pos2 == 0) {
                    value1 = value1 * 3.6e+6;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->s
                else if (pos1 == 3 && pos2 == 1) {
                    value1 = value1 * 3600;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->min
                else if (pos1 == 3 && pos2 == 2) {
                    value1 = value1 * 60;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->day
                else if (pos1 == 3 && pos2 == 4) {
                    value1 = value1 / 24;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->week
                else if (pos1 == 3 && pos2 == 5) {
                    value1 = value1 / 168;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->month
                else if (pos1 == 3 && pos2 == 6) {
                    value1 = value1 / 730;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //hour-->year
                else if (pos1 == 3 && pos2 == 7) {
                    value1 = value1 / 8760;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //day-->ms
                else if (pos1 == 4 && pos2 == 0) {
                    value1 = value1 * 8.64e+7;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->s
                else if (pos1 == 4 && pos2 == 1) {
                    value1 = value1 * 86400;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->min
                else if (pos1 == 4 && pos2 == 2) {
                    value1 = value1 * 1440;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->hour
                else if (pos1 == 4 && pos2 == 3) {
                    value1 = value1 * 24;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->week
                else if (pos1 == 4 && pos2 == 5) {
                    value1 = value1 / 7;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->month
                else if (pos1 == 4 && pos2 == 6) {
                    value1 = value1 / 30.417;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //day-->year
                else if (pos1 == 4 && pos2 == 7) {
                    value1 = value1 / 365;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //week-->ms
                else if (pos1 == 5 && pos2 == 0) {
                    value1 = value1 * 6.048e+8;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->s
                else if (pos1 == 5 && pos2 == 1) {
                    value1 = value1 * 604800;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->min
                else if (pos1 == 5 && pos2 == 2) {
                    value1 = value1 * 10080;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->hour
                else if (pos1 == 5 && pos2 == 3) {
                    value1 = value1 * 168;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->day
                else if (pos1 == 5 && pos2 == 4) {
                    value1 = value1 * 7;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->month
                else if (pos1 == 5 && pos2 == 6) {
                    value1 = value1 / 4.345;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //week-->year
                else if (pos1 == 5 && pos2 == 7) {
                    value1 = value1 / 52.143;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //month-->ms
                else if (pos1 == 6 && pos2 == 0) {
                    value1 = value1 * 2.628e+9;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->s
                else if (pos1 == 6 && pos2 == 1) {
                    value1 = value1 * 2.628e+6;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->min
                else if (pos1 == 6 && pos2 == 2) {
                    value1 = value1 * 43800;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->hour
                else if (pos1 == 6 && pos2 == 3) {
                    value1 = value1 * 730;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->day
                else if (pos1 == 6 && pos2 == 4) {
                    value1 = value1 * 30.417;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->week
                else if (pos1 == 6 && pos2 == 5) {
                    value1 = value1 * 4.345;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //month-->year
                else if (pos1 == 6 && pos2 == 7) {
                    value1 = value1 / 12;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                //year-->ms
                else if (pos1 == 7 && pos2 == 0) {
                    value1 = value1 * 3.154e+10;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->s
                else if (pos1 == 7 && pos2 == 1) {
                    value1 = value1 * 3.154e+7;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->min
                else if (pos1 == 7 && pos2 == 2) {
                    value1 = value1 * 525600;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->hour
                else if (pos1 == 7 && pos2 == 3) {
                    value1 = value1 * 8760;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->day
                else if (pos1 == 7 && pos2 == 4) {
                    value1 = value1 * 365;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->week
                else if (pos1 == 7 && pos2 == 5) {
                    value1 = value1 * 52.143;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }
                //year-->month
                else if (pos1 == 7 && pos2 == 6) {
                    value1 = value1 * 12;
                    ans_display3.setText("= " + value1 + siunits[pos2]);
                }

                else{
                    ans_display3.setText("= 0"  + siunits[pos2]);
                }





            }});

        Intent intent4 = new Intent();
    }
}