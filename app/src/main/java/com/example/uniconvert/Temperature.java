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

public class Temperature extends AppCompatActivity {
    TextView ans_display2;
    Spinner spinner5;
    Spinner spinner6;
    Button button4;
    Button calculate2;
    EditText user_input3;
    FloatingActionButton invert3;
    double value1;
    int pos1;
    int pos2;
    String[] siunits = {" °C", " °F", " K", " °R"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        ans_display2= findViewById(R.id.ans_display2);

        button4 = findViewById(R.id.button4);
        calculate2 = findViewById(R.id.calculate2);

        user_input3 = findViewById(R.id.user_input3);

        invert3 = findViewById(R.id.invert3);

        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_temp1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.units_temp2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter2);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos1 = spinner5.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos1, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Snackbar.make(adapterView, "Choose something", Snackbar.LENGTH_SHORT).show();
            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos2 = spinner6.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos2, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Snackbar.make(adapterView, "Choose something", Snackbar.LENGTH_SHORT).show();
            }
        });
        invert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner5.setSelection(pos2);
                spinner6.setSelection(pos1);
            }
        });

        calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_value = user_input3.getText().toString();
                try {
                    value1 = Double.parseDouble(input_value);

                } catch (NumberFormatException e) {
                    input_value = "0";
                }
                if (pos1 == pos2) {
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==0 && pos2==1){
                    value1 = (value1*9/5) + 32;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==0 && pos2==2){
                    value1 = value1 + 273.15;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==0 && pos2==3){
                    value1 = (value1*9/5) + 491.67;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }

                else if (pos1==1 && pos2==0){
                    value1 = (value1-32)*5/9;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==1 && pos2==2){
                    value1 = ((value1-32)*5/9)+273.15;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==1 && pos2==3){
                    value1 = value1 + 459.67;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }

                else if (pos1==2 && pos2==0){
                    value1 = value1 - 273.15;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==2 && pos2==1){
                    value1 = ((value1-273.15)*9/5)+32;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==2 && pos2==3){
                    value1 = value1*1.8;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }

                else if (pos1==3 && pos2==0){
                    value1 = (value1 - 491.67) * 5/9;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==3 && pos2==1){
                    value1 = value1-459.67;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }
                else if (pos1==3 && pos2==2){
                    value1 = value1*5/9;
                    ans_display2.setText("= " + value1 + siunits[pos2]);
                }



            }
        });




        Intent intent3 = new Intent();
    }
}