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

public class Volume extends AppCompatActivity {
    TextView ans_display4;
    Spinner spinner9;
    Spinner spinner10;
    Button button6;
    Button calculate4;
    EditText user_input5;
    FloatingActionButton invert5;
    double value1;
    int pos1;
    int pos2;
    String[] siunits = {" mL/ccm", " L", " Cm", " C.in.", " C.foot", "C.yards", " ounces", " gallons", " quarts"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        ans_display4= findViewById(R.id.ans_display4);

        button6 = findViewById(R.id.button6);
        calculate4 = findViewById(R.id.calculate4);

        user_input5 = findViewById(R.id.user_input5);

        invert5 = findViewById(R.id.invert5);

        spinner9 = findViewById(R.id.spinner9);
        spinner10 = findViewById(R.id.spinner10);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_volume1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.units_volume2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter2);

        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos1 = spinner9.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos1, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pos2 = spinner10.getSelectedItemPosition();
                Snackbar.make(view, "It is " + pos2, Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        invert5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner9.setSelection(pos2);
                spinner10.setSelection(pos1);
            }
        });

        calculate4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_value = user_input5.getText().toString();
                try {
                    value1 = Double.parseDouble(input_value);

                } catch (NumberFormatException e) {
                    input_value = "0";
                }
                if (pos1 == pos2) {
                    ans_display4.setText("= " + value1 + siunits[pos2]);

                }
                 //mL-->L
                else if (pos1==0 && pos2==1){
                    value1 = value1 / 1000;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->Cm
                else if (pos1==0 && pos2==2){
                    value1 = value1 / 1e+6;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->inch
                else if (pos1==0 && pos2==3){
                    value1 = value1 / 16.387;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->foot
                else if (pos1==0 && pos2==4){
                    value1 = value1 / 28317;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->yard
                else if (pos1==0 && pos2==5){
                    value1 = value1 / 764555;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->ounce
                else if (pos1==0 && pos2==6){
                    value1 = value1 / 28.413;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->gallon
                else if (pos1==0 && pos2==7){
                    value1 = value1 / 3785;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //mL-->quart
                else if (pos1==0 && pos2==8){
                    value1 = value1 / 946;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //L-->mL
                else if (pos1==1 && pos2==0){
                    value1 = value1 * 1000;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->Cm
                else if (pos1==1 && pos2==2){
                    value1 = value1 / 1000;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->inch
                else if (pos1==1 && pos2==3){
                    value1 = value1 * 61.024;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->foot
                else if (pos1==1 && pos2==4){
                    value1 = value1 / 28.317;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->yard
                else if (pos1==1 && pos2==5){
                    value1 = value1 / 765;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->ounce
                else if (pos1==1 && pos2==6){
                    value1 = value1 * 35.195;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->gallon
                else if (pos1==1 && pos2==7){
                    value1 = value1 / 3.785;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //L-->quart
                else if (pos1==1 && pos2==8){
                    value1 = value1 * 1.057;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //Cm-->mL
                else if (pos1==2 && pos2==0){
                    value1 = value1 * 1e+6;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cm-->L
                else if (pos1==2 && pos2==1){
                    value1 = value1 * 1000;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->inch
                else if (pos1==2 && pos2==3){
                    value1 = value1 *  61024;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->foot
                else if (pos1==2 && pos2==4){
                    value1 = value1 *35.315;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->yard
                else if (pos1==2 && pos2==5){
                    value1 = value1 * 1.308;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->ounce
                else if (pos1==2 && pos2==6){
                    value1 = value1 * 35195;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->gallon
                else if (pos1==2 && pos2==7){
                    value1 = value1 * 264;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //CM-->quart
                else if (pos1==2 && pos2==8){
                    value1 = value1 * 1057;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //Ci-->mL
                else if (pos1==3 && pos2==0){
                    value1 = value1 * 16.387;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->L
                else if (pos1==3 && pos2==1){
                    value1 = value1 / 61.024;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->cm
                else if (pos1==3 && pos2==2){
                    value1 = value1 /  61024;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->foot
                else if (pos1==3 && pos2==4){
                    value1 = value1 / 1728;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->yard
                else if (pos1==3 && pos2==5){
                    value1 = value1 / 46656;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->ounce
                else if (pos1==3 && pos2==6){
                    value1 = value1 / 1.734;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->gallon
                else if (pos1==3 && pos2==7){
                    value1 = value1 / 231;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Ci-->quart
                else if (pos1==3 && pos2==8){
                    value1 = value1 / 57.75;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //Cf-->mL
                else if (pos1==4 && pos2==0){
                    value1 = value1 * 28317;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->L
                else if (pos1==4 && pos2==1){
                    value1 = value1 *  28.317;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->cm
                else if (pos1==4 && pos2==2){
                    value1 = value1 / 35.315;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->inch
                else if (pos1==4 && pos2==3){
                    value1 = value1 * 1728;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->yard
                else if (pos1==4 && pos2==5){
                    value1 = value1 / 27;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->ounce
                else if (pos1==4 && pos2==6){
                    value1 = value1 * 997;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->gallon
                else if (pos1==4 && pos2==7){
                    value1 = value1 * 7.481;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cf-->quart
                else if (pos1==4 && pos2==8){
                    value1 = value1 * 29.922;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //Cy-->mL
                else if (pos1==5 && pos2==0){
                    value1 = value1 * 764555;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->L
                else if (pos1==5 && pos2==1){
                    value1 = value1 *  765;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->cm
                else if (pos1==5 && pos2==2){
                    value1 = value1 / 1.308;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->inch
                else if (pos1==5 && pos2==3){
                    value1 = value1 * 46656;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->foot
                else if (pos1==5 && pos2==4){
                    value1 = value1 * 27;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->ounce
                else if (pos1==5 && pos2==6){
                    value1 = value1 * 26909;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->gallon
                else if (pos1==5 && pos2==7){
                    value1 = value1 * 202;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //Cy-->quart
                else if (pos1==5 && pos2==8){
                    value1 = value1 * 808;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //oun-->mL
                else if (pos1==6 && pos2==0){
                    value1 = value1 * 28.413;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->L
                else if (pos1==6 && pos2==1){
                    value1 = value1 / 35.195;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->cm
                else if (pos1==6 && pos2==2){
                    value1 = value1 / 35195;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->inch
                else if (pos1==6 && pos2==3){
                    value1 = value1 * 1.734;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->foot
                else if (pos1==6 && pos2==4){
                    value1 = value1 / 997;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->yard
                else if (pos1==6 && pos2==5){
                    value1 = value1 / 26909;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->gallon
                else if (pos1==6 && pos2==7){
                    value1 = value1 / 133;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //oun-->quart
                else if (pos1==6 && pos2==8){
                    value1 = value1 / 33.307;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //gal-->mL
                else if (pos1==7 && pos2==0){
                    value1 = value1 * 3785;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->L
                else if (pos1==7 && pos2==1){
                    value1 = value1 * 3.785;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->cm
                else if (pos1==7 && pos2==2){
                    value1 = value1 / 264;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->inch
                else if (pos1==7 && pos2==3){
                    value1 = value1 * 231;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->foot
                else if (pos1==7 && pos2==4){
                    value1 = value1 / 7.481;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->yard
                else if (pos1==7 && pos2==5){
                    value1 = value1 / 202;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->ounce
                else if (pos1==7 && pos2==6){
                    value1 = value1 * 128;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //gal-->quart
                else if (pos1==7 && pos2==8){
                    value1 = value1 * 4;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

                //qua-->mL
                else if (pos1==8 && pos2==0){
                    value1 = value1 * 946;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->L
                else if (pos1==8 && pos2==1){
                    value1 = value1 / 1.057;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->cm
                else if (pos1==8 && pos2==2){
                    value1 = value1 / 1057;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->inch
                else if (pos1==8 && pos2==3){
                    value1 = value1 * 57.75;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->foot
                else if (pos1==8 && pos2==4){
                    value1 = value1 / 29.922;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->yard
                else if (pos1==8 && pos2==5){
                    value1 = value1 / 808;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->ounce
                else if (pos1==8 && pos2==6){
                    value1 = value1 * 33.307;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }
                //qua-->gallon
                else if (pos1==8 && pos2==7){
                    value1 = value1 / 4;
                    ans_display4.setText("= " + value1 + siunits[pos2]);
                }

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_input5.setText("");
                ans_display4.setText("");
            }
        });



       Intent intent5 = new Intent();

    }
}