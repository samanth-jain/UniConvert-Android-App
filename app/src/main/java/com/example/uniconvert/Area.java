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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Area extends AppCompatActivity {
    TextView ans_display;
    Spinner spinner;
    Spinner spinner4;
    Button button3;
    Button calculate;
    EditText user_input2;
    FloatingActionButton invert2;
    double value1;
    int pos1;
    int pos2;
    String[] siunits = {" sq.mm", " sq.cm", " sq.m", " sq.km", " sq.inch", " sq.feet", " sq.yards", " sq.miles", " hectare", " acre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ans_display= findViewById(R.id.ans_display);

        button3 = findViewById(R.id.button3);
        calculate = findViewById(R.id.calculate);

        user_input2 = findViewById(R.id.user_input2);

        invert2 = findViewById(R.id.invert2);

        spinner = findViewById(R.id.spinner);
        spinner4 = findViewById(R.id.spinner4);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_area1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.units_area2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner4.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos1 = spinner.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos1, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Area.this, "Select something", Toast.LENGTH_LONG).show();
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos2 = spinner4.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos2, Snackbar.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Area.this, "Select something", Toast.LENGTH_SHORT).show();
            }


        });
        invert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setSelection(pos2);
                spinner4.setSelection(pos1);
                ans_display.setText("");

            }
        });



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_value = user_input2.getText().toString();
                try {
                    value1 = Double.parseDouble(input_value);

                } catch (NumberFormatException e) {
                    input_value = "0";
                }

                if (pos1 == pos2) {
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //mm-->cm
                else if (pos1 == 0 && pos2 == 1) {
                    value1 = value1 / 100;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mm-->m
                else if (pos1 == 0 && pos2 == 2) {
                    value1 = value1 / 1e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mm-->km
                else if (pos1 == 0 && pos2 == 3) {
                    value1 = value1 / 1e+12;

                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mm-->inch
                else if (pos1 == 0 && pos2 == 4) {
                    value1 = value1 / 645;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mm-->feet
                else if (pos1 == 0 && pos2 == 5) {
                    value1 = value1 / 92903;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }


                //cm-->mm
                else if (pos1 == 1 && pos2 == 0) {
                    value1 = value1 * 100;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //cm-->m
                else if (pos1 == 1 && pos2 == 2) {
                    value1 = value1 / 10000;

                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //cm-->km
                else if (pos1 == 1 && pos2 == 3) {
                    value1 = value1 / 1e+10;

                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //cm-->inch
                else if (pos1 == 1 && pos2 == 4) {
                    value1 = value1 / 6.452;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //cm-->feet
                else if (pos1 == 1 && pos2 == 5) {
                    value1 = value1 / 929;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //cm-->yards
                else if (pos1 == 1 && pos2 == 6) {
                    value1 = value1 / 8361;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //m-->mm
                else if (pos1 == 2 && pos2 == 0) {
                    value1 = value1 * 1e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->cm
                else if (pos1 == 2 && pos2 == 1) {
                    value1 = value1 * 10000;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->km
                else if (pos1 == 2 && pos2 == 3) {
                    value1 = value1 / 1e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->inch
                else if (pos1 == 2 && pos2 == 4) {
                    value1 = value1 * 1550;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->feet
                else if (pos1 == 2 && pos2 == 5) {
                    value1 = value1 * 10.764;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->miles
                else if (pos1 == 2 && pos2 == 6) {
                    value1 = value1 / 2.59e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->yards
                else if (pos1 == 2 && pos2 == 7) {
                    value1 = value1 * 1.196;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->hectare
                else if (pos1 == 2 && pos2 == 8) {
                    value1 = value1 / 10000;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //m-->acre
                else if (pos1 == 2 && pos2 == 9){
                    value1 = value1 / 4047;
                }

                //km-->cm
                else if (pos1 == 3 && pos2 == 1) {
                    value1 = value1 * 1e+10;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->m
                else if (pos1 == 3 && pos2 == 2) {
                    value1 = value1 * 1e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->inch
                else if (pos1 == 3 && pos2 == 4) {
                    value1 = value1 * 1.55e+9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->feet
                else if (pos1 == 3 && pos2 == 5) {
                    value1 = value1 * 1.076e+7;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->miles
                else if (pos1 == 3 && pos2 == 6) {
                    value1 = value1 / 2.59;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->yards
                else if (pos1 == 3 && pos2 == 7) {
                    value1 = value1 * 1.196e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->hectare
                else if (pos1 == 3 && pos2 == 8) {
                    value1 = value1 * 100;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //km-->acre
                else if (pos1 == 3 && pos2 == 9){
                    value1 = value1 * 247;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //inch-->cm
                else if (pos1 == 4 && pos2 == 1) {
                    value1 = value1 * 6.452;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->m
                else if (pos1 == 4 && pos2 == 2) {
                    value1 = value1 / 1550;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->km
                else if (pos1 == 4 && pos2 == 3) {
                    value1 = value1 / 1.55e+9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->feet
                else if (pos1 == 4 && pos2 == 5) {
                    value1 = value1 / 144;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->miles
                else if (pos1 == 4 && pos2 == 6) {
                    value1 = value1 / 4.014e+9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->yards
                else if (pos1 == 4 && pos2 == 7) {
                    value1 = value1 /1296;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->hectare
                else if (pos1 == 4 && pos2 == 8) {
                    value1 = value1 / 1.55e+7;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //inch-->acre
                else if (pos1 == 4 && pos2 == 9){
                    value1 = value1 / 6.273e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }


                //feet-->m
                else if (pos1 == 5 && pos2 == 2) {
                    value1 = value1 / 10.764;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->km
                else if (pos1 == 5 && pos2 == 3) {
                    value1 = value1 / 1.076e+7;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->inch
                else if (pos1 == 5 && pos2 == 4) {
                    value1 = value1 * 144;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->mile
                else if (pos1 == 5 && pos2 == 6) {
                    value1 = value1 / 2.788e+7;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->yards
                else if (pos1 == 5 && pos2 == 7) {
                    value1 = value1 /9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->hectare
                else if (pos1 == 5 && pos2 == 8) {
                    value1 = value1 / 107639;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //feet-->acre
                else if (pos1 == 5 && pos2 == 9){
                    value1 = value1 / 43560;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //mile-->m
                else if (pos1 == 6 && pos2 == 2) {
                    value1 = value1 * 2.59e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mile-->km
                else if (pos1 == 6 && pos2 == 3) {
                    value1 = value1 *2.59;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mile-->inch
                else if (pos1 == 6 && pos2 == 4) {
                    value1 = value1 * 4.014e+9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mile-->hectare
                else if (pos1 == 6 && pos2 == 8) {
                    value1 = value1 * 259;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //mile-->acre
                else if (pos1 == 6 && pos2 == 9){
                    value1 = value1 * 640;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //yard-->cm
                else if (pos1 == 7 && pos2 == 1) {
                    value1 = value1 *  8361;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->m
                else if (pos1 == 7 && pos2 == 2) {
                    value1 = value1 / 1.196;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->km
                else if (pos1 == 7 && pos2 == 3) {
                    value1 = value1 / 1.196e+6;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->inch
                else if (pos1 == 7 && pos2 == 4) {
                    value1 = value1 * 1296;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->feet
                else if (pos1 == 7 && pos2 == 6) {
                    value1 = value1 * 9;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->hectare
                else if (pos1 == 7 && pos2 == 8) {
                    value1 = value1 / 11960;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //yard-->acre
                else if (pos1 == 7 && pos2 == 9){
                    value1 = value1 / 4840;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //hect-->m
                else if (pos1 == 8 && pos2 == 2) {
                    value1 = value1 * 10000;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //hect-->km
                else if (pos1 == 8 && pos2 == 3) {
                    value1 = value1 / 100;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //hect-->feet
                else if (pos1 == 8 && pos2 == 5) {
                    value1 = value1 * 107639;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //hect-->miles
                else if (pos1 == 8 && pos2 == 6) {
                    value1 = value1 / 259;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //hect-->yard
                else if (pos1 == 8 && pos2 == 7) {
                    value1 = value1 * 11960;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //hect-->acre
                else if (pos1 == 8 && pos2 == 9){
                    value1 = value1 * 2.471;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                //ac-->m
                else if (pos1 == 9 && pos2 == 2) {
                    value1 = value1 * 4047;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //ac-->km
                else if (pos1 == 9 && pos2 == 3) {
                    value1 = value1 / 247;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //ac-->feet
                else if (pos1 == 9 && pos2 == 5) {
                    value1 = value1 * 43560;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //ac-->miles
                else if (pos1 == 9 && pos2 == 6) {
                    value1 = value1 / 640;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //ac-->yard
                else if (pos1 == 9 && pos2 == 7) {
                    value1 = value1 * 4840;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }
                //ac-->hect
                else if (pos1 == 9 && pos2 == 8){
                    value1 = value1 / 2.471;
                    ans_display.setText("= " + value1 + siunits[pos2]);
                }

                else{
                    ans_display.setText("Value too big/small to convert");
                }

            }});
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_input2.setText("");
                ans_display.setText("");
            }
        });




        Intent intent2 = getIntent();
    }
}