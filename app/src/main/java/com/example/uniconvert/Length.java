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

public class Length extends AppCompatActivity {
    TextView textView3;
    Spinner spinner2;
    Spinner spinner3;
    Button button;
    Button button2;
    EditText user_input;
    FloatingActionButton invert;
    double value;
    String siunits[] = {"nm", "µm", "mm", "cm", "m", "km", "inch", "feet", "miles", "yards", "nautical miles" };


    int pos1;
    int pos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        textView3 = findViewById(R.id.textView3);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        user_input = findViewById(R.id.user_input);

        invert = findViewById(R.id.invert);

        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_length, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.units_length2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter2);


                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        pos1 = spinner2.getSelectedItemPosition();
                        Toast.makeText(Length.this, "Item selected: " + pos1, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(Length.this, "Select atleast one field", Toast.LENGTH_SHORT).show();


                    }
                });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos2 = spinner3.getSelectedItemPosition();
                Toast.makeText(Length.this, "Item selected: " + pos2, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Length.this, "Select atleast one field", Toast.LENGTH_SHORT).show();
            }
        });
        invert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                spinner2.setSelection(pos2);
                spinner3.setSelection(pos1);
                textView3.setText("");

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          String input_value = user_input.getText().toString();
                                          try {
                                              value = Double.parseDouble(input_value);

                                          } catch (NumberFormatException e) {
                                              input_value = "0";
                                          }

                                          if (pos1 == pos2) {
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //nm--->microm
                                          else if (pos1 == 0 && pos2 == 1) {
                                              value = value / 1000;
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nm--->mm
                                          else if (pos1 == 0 && pos2 == 2) {
                                              value = value / 1e+6;
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nm--->cm
                                          else if (pos1 == 0 && pos2 == 3) {
                                              value = value / 1e+7;
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nm--->m
                                          else if (pos1 == 0 && pos2 == 4) {
                                              value = value / 1e+9;
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nm--->km
                                          else if (pos1 == 0 && pos2 == 5) {
                                              value = value / 1e+12;
                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nm-->inches
                                          else if (pos1 == 0 && pos2 == 6) {
                                              value = value / 2.54e+7;
                                              textView3.setText(value + siunits[pos2]);
                                          }

                                          //micm-->nm
                                          else if (pos1 == 1 && pos2 == 0) {

                                              textView3.setText("= " + value * 1000 + siunits[pos2]);
                                          }
                                          //micm-->mm
                                          else if (pos1 == 1 && pos2 == 2) {

                                              textView3.setText("= " + value / 1000 + siunits[pos2]);
                                          }
                                          //micm-->cm
                                          else if (pos1 == 1 && pos2 == 3) {
                                              value = value / 10000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //micm-->m
                                          else if (pos1 == 1 && pos2 == 4) {
                                              value = value / 1e+6;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //micm-->km
                                          else if (pos1 == 1 && pos2 == 5) {
                                              value = value / 1e+9;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //micm-->inch
                                          else if (pos1 == 1 && pos2 == 6) {
                                              value = value / 25400;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //micm-->feet
                                          else if (pos1 == 1 && pos2 == 7) {
                                              value = value / 304800;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //mm-->nm
                                          else if (pos1 == 2 && pos2 == 0) {

                                              textView3.setText("= " + value * 1e+6 + siunits[pos2]);
                                          }
                                          //mm-->micm
                                          else if (pos1 == 2 && pos2 == 1) {

                                              textView3.setText("= " + value * 1000 + siunits[pos2]);
                                          }
                                          //mm-->cm
                                          else if (pos1 == 2 && pos2 == 3) {
                                              value = value / 10;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mm-->m
                                          else if (pos1 == 2 && pos2 == 4) {
                                              value = value / 1000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mm-->km
                                          else if (pos1 == 2 && pos2 == 5) {
                                              value = value / 1e+6;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mm-->inch
                                          else if (pos1 == 2 && pos2 == 6) {
                                              value = value / 25.4                                              ;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mm-->feet
                                          else if (pos1 == 2 && pos2 == 7) {
                                              value = value / 305;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //cm-->nm
                                          else if (pos1 == 3 && pos2 == 0) {

                                              textView3.setText("= " + value * 1e+7 + siunits[pos2]);
                                          }
                                          //cm-->micm
                                          else if (pos1 == 3 && pos2 == 1) {

                                              textView3.setText("= " + value * 10000 + siunits[pos2]);
                                          }
                                          //cm-->mm
                                          else if (pos1 == 3 && pos2 == 2) {
                                              value = value * 10;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->m
                                          else if (pos1 == 3 && pos2 == 4) {
                                              value = value / 100;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->km
                                          else if (pos1 == 3 && pos2 == 5) {
                                              value = value / 100000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->inch
                                          else if (pos1 == 3 && pos2 == 6) {
                                              value = value / 2.54                                              ;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->feet
                                          else if (pos1 == 3 && pos2 == 7) {
                                              value = value / 30.48;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->miles
                                          else if (pos1 == 3 && pos2 == 8) {
                                              value = value / 160934;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->yards
                                          else if (pos1 == 3 && pos2 == 9) {
                                              value = value / 91.44;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //cm-->nauti
                                          else if (pos1 == 3 && pos2 == 10) {
                                              value = value / 185200;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //m-->nm
                                          else if (pos1 == 4 && pos2 == 0) {

                                              textView3.setText("= " + value * 1e+9 + siunits[pos2]);
                                          }
                                          //m-->micm
                                          else if (pos1 == 4 && pos2 == 1) {

                                              textView3.setText("= " + value * 1e+6 + siunits[pos2]);
                                          }
                                          //m-->mm
                                          else if (pos1 == 4 && pos2 == 2) {
                                              value = value * 1000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->cm
                                          else if (pos1 == 4 && pos2 == 3) {
                                              value = value * 100;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                         //m-->km
                                          else if (pos1 == 4 && pos2 == 5) {
                                              value = value / 1000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->inch
                                          else if (pos1 == 4 && pos2 == 6) {
                                              value = value *39.37;                                              ;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->feet
                                          else if (pos1 == 4 && pos2 == 7) {
                                              value = value * 3.281;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->miles
                                          else if (pos1 == 4 && pos2 == 8) {
                                              value = value / 1609;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->yards
                                          else if (pos1 == 4 && pos2 == 9) {
                                              value = value * 1.094;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //m-->nauti
                                          else if (pos1 == 4 && pos2 == 10) {
                                              value = value / 1852;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //km-->nm
                                          else if (pos1 == 5 && pos2 == 0) {

                                              textView3.setText("= " + value * 1e+12 + siunits[pos2]);
                                          }
                                          //km-->micm
                                          else if (pos1 == 5 && pos2 == 1) {

                                              textView3.setText("= " + value * 1e+9 + siunits[pos2]);
                                          }
                                          //km-->mm
                                          else if (pos1 == 5 && pos2 == 2) {
                                              value = value * 1e+6;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->cm
                                          else if (pos1 == 5 && pos2 == 3) {
                                              value = value * 100000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->m
                                          else if (pos1 == 5 && pos2 == 4) {
                                              value = value * 1000;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->inch
                                          else if (pos1 == 5 && pos2 == 6) {
                                              value = value * 39370;                                              ;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->feet
                                          else if (pos1 == 5 && pos2 == 7) {
                                              value = value * 3281;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->miles
                                          else if (pos1 == 5 && pos2 == 8) {
                                              value = value / 1.609;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->yards
                                          else if (pos1 == 5 && pos2 == 9) {
                                              value = value * 1094;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //km-->nauti
                                          else if (pos1 == 5 && pos2 == 10) {
                                              value = value / 1.852;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }


                                          //in-->mm
                                          else if (pos1 == 6 && pos2 == 2) {
                                              value = value * 25.4;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->cm
                                          else if (pos1 == 6 && pos2 == 3) {
                                              value = value * 2.54;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->m
                                          else if (pos1 == 6 && pos2 == 4) {
                                              value = value * 39.37;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->km
                                          else if (pos1 == 6 && pos2 == 5) {
                                              value = value * 39.37;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                         //in-->feet
                                          else if (pos1 == 6 && pos2 == 7) {
                                              value = value / 12;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->miles
                                          else if (pos1 == 6 && pos2 == 8) {
                                              value = value / 63360;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->yards
                                          else if (pos1 == 6 && pos2 == 9) {
                                              value = value / 36;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //in-->nauti
                                          else if (pos1 == 6 && pos2 == 10) {
                                              value = value / 72913;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //feet-->mm
                                          else if (pos1 == 7 && pos2 == 2) {
                                              value = value * 305;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->cm
                                          else if (pos1 == 7 && pos2 == 3) {
                                              value = value * 305;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->m
                                          else if (pos1 == 7 && pos2 == 4) {
                                              value = value / 3.281;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->km
                                          else if (pos1 == 7 && pos2 == 5) {
                                              value = value / 3281;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->inch
                                          else if (pos1 == 7 && pos2 == 6) {
                                              value = value * 12;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->miles
                                          else if (pos1 == 7 && pos2 == 8) {
                                              value = value / 5280;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->yards
                                          else if (pos1 == 7 && pos2 == 9) {
                                              value = value / 3;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //feet-->nauti
                                          else if (pos1 == 7 && pos2 == 10) {
                                              value = value / 6076;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //mile-->cm
                                          else if (pos1 == 8 && pos2 == 3) {
                                              value = value * 160934;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->m
                                          else if (pos1 == 8 && pos2 == 4) {
                                              value = value / 1609;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->km
                                          else if (pos1 == 8 && pos2 == 5) {
                                              value = value / 1.609;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->inch
                                          else if (pos1 == 8 && pos2 == 6) {
                                              value = value * 63360;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->feet
                                          else if (pos1 == 8 && pos2 == 7) {
                                              value = value * 5280;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->yards
                                          else if (pos1 == 8 && pos2 == 9) {
                                              value = value * 1760;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //mile-->nauti
                                          else if (pos1 == 8 && pos2 == 10) {
                                              value = value / 1.151;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //yard-->cm
                                          else if (pos1 == 9 && pos2 == 3) {
                                              value = value * 91.44;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->m
                                          else if (pos1 == 9 && pos2 == 4) {
                                              value = value / 1.094;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->km
                                          else if (pos1 == 9 && pos2 == 5) {
                                              value = value / 1094;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->inch
                                          else if (pos1 == 9 && pos2 == 6) {
                                              value = value * 36;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->feet
                                          else if (pos1 == 9 && pos2 == 7) {
                                              value = value * 3;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->miles
                                          else if (pos1 == 9 && pos2 == 8) {
                                              value = value / 1760;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //yard-->nauti
                                          else if (pos1 == 9 && pos2 == 10) {
                                              value = value / 2025;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          //nauti-->m
                                          else if (pos1 == 10 && pos2 == 4) {
                                              value = value * 1852;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nauti-->km
                                          else if (pos1 == 10 && pos2 == 5) {
                                              value = value * 1.852;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nauti-->inch
                                          else if (pos1 == 10 && pos2 == 6) {
                                              value = value * 72913;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nauti-->feet
                                          else if (pos1 == 10 && pos2 == 7) {
                                              value = value * 6076;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nauti-->miles
                                          else if (pos1 == 10 && pos2 == 8) {
                                              value = value * 1.151;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }
                                          //nauti-->yard
                                          else if (pos1 == 10 && pos2 == 9) {
                                              value = value * 2025;

                                              textView3.setText("= " + value + siunits[pos2]);
                                          }

                                          else {
                                              textView3.setText("Value too big/small to convert");

                                          }
                                      }});


        button2.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View view){
                user_input.setText("");
                textView3.setText("");
            }
            });

        Intent intent = getIntent();
    }


}




